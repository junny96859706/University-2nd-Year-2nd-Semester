import paho.mqtt.client as mqtt

def on_message(client, userdata, msg):
	m = str(msg.payload.decode("utf-8"))
	if msg.topic == "temp":
		print("온도:", m)
	elif msg.topic == "humidity":
		print("습도:", m)

ip = input("브로커의 IP 주소>>")
client = mqtt.Client(mqtt.CallbackAPIVersion.VERSION2)
client.on_message = on_message # on_message 콜백 함수 등록
client.connect(ip, 1883) # 브로커에 연결
client.loop_start()

while True:
	menu = int(input(""))
	if menu == 0:
		client.unsubscribe("temp")
		client.unsubscribe("humidity")
	elif menu == 1:
		client.subscribe("temp")
		client.unsubscribe("humidity")
	elif menu == 2:
		client.unsubscribe("temp")
		client.subscribe("humidity")
	elif menu == 3:
		client.subscribe("temp")
		client.subscribe("humidity")

client.loop_forever() # 메시지 루프를 실행하는 스레드 생성