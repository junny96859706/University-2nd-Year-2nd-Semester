import time
import RPi.GPIO as GPIO

# pin에 연결된 LED에  value(0/1) 값을 출력하여 LED를 켜거나 끄는 함수
def led_on_off(pin, value):
	GPIO.output(pin, value)

def measure_distance(trig, echo):
	time.sleep(0.2) # 초음파 센서의 준비 시간을 위해 필연적인 200밀리초 지연
	GPIO.output(trig, 1) # trig 핀에 1(High) 출력
	GPIO.output(trig, 0) # trig 핀에 0(Low) 출력. High->Low. 초음파 발사 지시

	while(GPIO.input(echo) == 0): # echo 핀 값이 0->1로 바뀔 때까지 루프
		pass

	# echo 핀 값이 1이면 초음파가 발사되었음
	pulse_start = time.time() # 초음파 발사 시간 기록
	while(GPIO.input(echo) == 1): # echo 핀 값이 1->0으로 바뀔 때까지 루프
		pass

	# echo 핀 값이 0이 되면 초음파 수신하였음
	pulse_end = time.time() # 초음파가 되돌아 온 시간 기록
	pulse_duration = pulse_end - pulse_start # 경과 시간 계산
	return pulse_duration*340*100/2 # 거리 계산하여 리턴(단위 cm)

trig = 20 # GPIO20
echo = 16 # GPIO16
GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)
GPIO.setup(trig, GPIO.OUT)
GPIO.setup(echo, GPIO.IN)

led = 6 # GPIO6 핀
GPIO.setup(led, GPIO.OUT) # GPIO6 핀을 출력으로 지정

while True:
	distance = measure_distance(trig, echo)
	if distance >= 20:
		led_on_off(led, GPIO.LOW)
	else:
		led_on_off(led, GPIO.HIGH)