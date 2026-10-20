import time
import RPi.GPIO as GPIO
import busio
import digitalio
import board
import adafruit_mcp3xxx.mcp3008 as MCP
from adafruit_mcp3xxx.analog_in import AnalogIn

GPIO.setmode(GPIO.BCM)
GPIO.setwarnings(False)

spi = busio.SPI(clock=board.SCK, MISO=board.MISO, MOSI=board.MOSI)
# cs(chip select) 핀 설정 – GPIO 12번
cs = digitalio.DigitalInOut(board.D12) # board.D12는 GPIO 12번 핀을 의미
mcp = MCP.MCP3008(spi, cs) # MCP3202 칩을 제어할 객체 생성
# 0번 채널(CH0)에서 아날로그 조도 값을 읽을 mcp_chan0 객체 생성
mcp_chan0 = AnalogIn(mcp, MCP.P0) # MCP.P0은 MCP3202의 0번 채널을 뜻함

prev_lum = mcp_chan0.value //16  # 이전 조도
increase_count = 0 # 연속 증가 수
while True:
	cur_lum = mcp_chan0.value //16 # 현재 조도 
	print(cur_lum) # 현재 조도 출력

	if cur_lum > prev_lum*1.05: # 5% 이상 증가
		increase_count += 1 # 조도 증가 카운트 1 증가
		if increase_count == 3: # 3번 연속 조도가 증가한 경우
			print("갑자기 밝아지고 있음")
			increase_count = 0
		else:
			pass
	else:
		increase_count = 0 # 증가 수를 0으로 초기화
	prev_lum = cur_lum # 현재 조도 값을 이전 조도로 변경
	time.sleep(1) # 1초 지연