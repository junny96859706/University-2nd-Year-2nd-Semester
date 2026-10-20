import paho.mqtt.client as mqtt
import random
import time

ip = input("브로커의 IP 주소>>")
client = mqtt.Client(mqtt.CallbackAPIVersion.VERSION2)
client.connect(ip, 1883) # 브로커에 연결
client.loop_start() # 메시지 루프를 실행하는 스레드 생성

print("1초 간격으로 온도 전송 중...")
while True:
	time.sleep(1) # 1초 간격으로
	message = random.randint(0,100)
	client.publish("temp", str(message))

client.loop_stop() # 메시지 루프를 실행하는 스레드 종료
client.disconnect()