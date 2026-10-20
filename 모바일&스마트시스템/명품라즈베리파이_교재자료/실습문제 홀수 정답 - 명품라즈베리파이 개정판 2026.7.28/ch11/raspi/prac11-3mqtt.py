import time
import paho.mqtt.client as mqtt

ip = "localhost" # 현재 브로커는 이 컴퓨터에 설치되어 있음

client = mqtt.Client(mqtt.CallbackAPIVersion.VERSION2)
client.connect(ip, 1883) # 브로커에 연결
client.loop_start() # 메시지 루프를 실행하는 스레드 생성

while True:
	text = input("텍스트 입력>>")
	client.publish("text", text)
	time.sleep(1)

client.loop_stop() # 메시지 루프를 실행하는 스레드 종료
client.disconnect()