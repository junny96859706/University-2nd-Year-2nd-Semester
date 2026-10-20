import time
import RPi.GPIO as GPIO
from adafruit_htu21d import HTU21D
import busio

# pin에 연결된 LED에 value(0/1) 값을 출력하여 LED를 켜거나 끄는 함수
def led_on_off(pin, value):
	GPIO.output(pin, value)

# 센서로부터 온도 값을 수신하여 리턴하는 함수
def getTemperature(sensor):
	return float(sensor.temperature)  # HTU21D 장치로부터 온도 값 읽기

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)

led = 6  # GPIO6 핀
GPIO.setup(led, GPIO.OUT)  # GPIO6 핀을 출력으로 지정

sda = 2  # GPIO2 핀. sda 이름이 붙여진 핀
scl = 3  # GPIO3 핀. scl 이름이 붙여진 핀
i2c = busio.I2C(scl, sda)  # I2C 버스 통신을 실행하는 객체 생성
sensor = HTU21D(i2c)  # I2C 버스에서 HTU21D 장치를 제어하는 객체 생성

THRESHOLD = 25  # 온도 임계치
prev_temp = 0  # 이전 온도를 저장하는 변수. 0으로 초기화

while True:
	cur_temp = getTemperature(sensor)  # cur_temp는 현재 온도 저장

	if prev_temp < THRESHOLD and cur_temp >= THRESHOLD:  # 온도가 THRESHOLD 이상으로 오른 경우
		led_on_off(led, 1)  # LED에 불 켜기
	elif prev_temp >= THRESHOLD and cur_temp < THRESHOLD:  # 온도가 THRESHOLD 밑으로 떨어진 경우
		led_on_off(led, 0)  # LED에 불 끄기
	else:  # 동일한 상태인 경우
		pass  # 이전 상태 그대로 둠

	print("현재 온도는 %4.1f" % cur_temp)
	prev_temp = cur_temp  # 현재 온도는 이전 온도가 됨
	time.sleep(1)  # 1초 간격으로 실행