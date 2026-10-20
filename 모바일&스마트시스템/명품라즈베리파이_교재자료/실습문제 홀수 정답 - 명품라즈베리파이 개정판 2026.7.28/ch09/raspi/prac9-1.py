import time
import RPi.GPIO as GPIO
from adafruit_htu21d import HTU21D
import busio

# pin에 연결된 LED에  value(0/1) 값을 출력하여 LED를 켜거나 끄는 함수
def led_on_off(pin, value):
	GPIO.output(pin, value)

# 센서로부터 온도 값을 수신하여 리턴하는 함수
def getTemperature(sensor) :
	return float(sensor.temperature) # HTU21D 장치로부터 온도 값 읽기

# 센서로부터 습도 값을 수신하여 리턴하는 함수
def getHumidity(sensor) : # 센서로부터 습도 값 수신 함수
	return float(sensor.relative_humidity) # HTU21D 장치로부터 습도 값 읽기

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)

led = 6 # GPIO6 핀
GPIO.setup(led, GPIO.OUT) # GPIO6 핀을 출력으로 지정

sda = 2 # GPIO2 핀. sda 이름이 붙여진 핀
scl = 3 # GPIO3 핀. scl 이름이 붙여진 핀

i2c = busio.I2C(scl, sda) # I2C 버스 통신을 실행하는 객체 생성
sensor = HTU21D(i2c) # I2C 버스에서 HTU21D 장치를 제어하는 객체 리턴

THRESHOLD_TEMP = 30 # 체크할 온도
THRESHOLD_HUMI = 80 # 체크할 습도

led_on_off(led, 0) # 초기에 LED에 불 끄기
while True :
	cur_temp = getTemperature(sensor)
	cur_humi = getHumidity(sensor)
	print("온도는 %4.1d, 습도는 %4.1d %%" % (cur_temp, cur_humi))

	if cur_temp >= THRESHOLD_TEMP and cur_humi >= THRESHOLD_HUMI: # 온도와 습도가 모두 THRESHOLD 이상인 경우
		led_on_off(led, 1) # LED에 불 켜기
		print("너무 습하고 더워요!")
	else: # 아닌 경우
		led_on_off(led, 0) # LED에 불 끄기

	time.sleep(1) # 1초 간격으로 실행
