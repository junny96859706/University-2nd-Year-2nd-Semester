from socket import *

student_id = "2371214"
student_name = "이지형"

# 서버포트설정
serverPort = 12000
# UDP 소켓 생성 및 포트 바인딩
serverSocket = socket(AF_INET, SOCK_DGRAM)
serverSocket.bind(('', serverPort))

print(f"==========================================")
print(f" UDP Server Started by [{student_id} {student_name}]")
print(f" The server is ready to receive (Port: {serverPort})")
print(f"==========================================\n")

while True:
    # 데이터 및 클라이언트 주소 수신
    message, clientAddress = serverSocket.recvfrom(2048)
    
    # 수신한 데이터 디코딩 후 출력
    decoded_message = message.decode()
    print(f"[Received from {clientAddress}]: {decoded_message}")
    
    modifiedMessage = decoded_message.upper()
    serverSocket.sendto(modifiedMessage.encode(), clientAddress)
