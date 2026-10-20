import time
import paho.mqtt.client as mqtt
import RPi.GPIO as GPIO

def on_connect(client, userdata, flag, rc, prop=None):
	client.subscribe("ledreq") # "ledreq" 토픽으로 구독 신청
	client.publish("led", led_status) # “led” 토픽으로 led 상태 전송

#"ledreq" 토픽으로 메세지가 날라오면 현재 led 상태를 publish
def on_message(client, userdata, msg) :
	global led_status # led_status는 전역 변수임
	client.publish("led", led_status) # “led” 토픽으로 led 상태 전송

	#on_off = int(msg.payload); # on_off는 0 또는 1의 정수
	#circuit.controlLED(on_off) # LED를 켜거나 끔  

# pin에 연결된 LED에 value(0/1) 값을 출력하여 LED를 켜거나 끄는 함수
def led_on_off(pin, value):
	GPIO.output(pin, value)

# button이 눌러질 때 호출되는 콜백 함수
def button_pressed(pin):
	# publish led 토픽으로
	global led_status # led_status는 전역 변수임
	global led # led는 전역 변수임
	led_status = 0 if led_status == 1 else 1
	led_on_off(led, led_status)
	client.publish("led", led_status) # “led” 토픽으로 led 상태 전송

# LED를 다루기 위한 전역 변수 선언 및 초기화
led = 6 # GPIO6
button = 21 # GPIO21
led_status = 0 # 현재 led의 상태. 1이면 켜져 있음

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)
GPIO.setup(led, GPIO.OUT) # led 핀을 출력으로 지정
GPIO.setup(button, GPIO.IN, GPIO.PUD_DOWN) # button 핀을 입력으로 지정

# button을 누르면 10ms의 디바운스 후 button_pressed()가 호출되도록 설정
GPIO.add_event_detect(button, GPIO.RISING, button_pressed, 10)

# 초기화(가장 처음 한 번만 실행)
led_on_off(led, led_status) # 현재 실제 led 상태에 상관없이 led를 꺼진 상태로 초기화

ip = "localhost" # 현재 브로커는 이 컴퓨터에 설치되어 있음

client = mqtt.Client(mqtt.CallbackAPIVersion.VERSION2)
client.on_connect = on_connect
client.on_message = on_message

client.connect(ip, 1883) # 브로커에 연결
client.loop_forever() # 메시지 루프
