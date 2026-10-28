from socket import *

student_id = "2371214"
student_name = "이 지 형 "
serverName = '127.0.0.1'
serverPort = 12000

clientSocket = socket(AF_INET, SOCK_DGRAM)

print("==========================================")
print(f" UDP Client Running [{student_id} {student_name}]")
print(" (종료하려면 'q' 또는 'exit'를 입력하세요)")
print("==========================================\n")

while True:
    message = input("Input lowercase sentence: ")
    
    if message.lower() in ['q', 'exit']:
        print("\n[Client] 통신을 종료합니다.")
        break

    full_message = f"[{student_id} {student_name}] {message}"
    clientSocket.sendto(full_message.encode(), (serverName, serverPort))

    modifiedMessage, serverAddress = clientSocket.recvfrom(2048)

    print(f"From Server: {modifiedMessage.decode()}\n")

clientSocket.close()
