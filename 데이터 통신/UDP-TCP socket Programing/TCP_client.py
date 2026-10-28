from socket import *

student_id = "2371214"
student_name = "이 지 형 "

serverName = '127.0.0.1'
serverPort = 12000

print("==========================================")
print(f" TCP Client Running [{student_id} {student_name}]")
print(" (종 료 하 려 면  'q' 또는  'exit'를  입 력 하 세 요 )")
print("==========================================\n")

while True:
    sentence = input("Input lowercase sentence: ")

    if sentence.lower() in ['q', 'exit']:
        print("\n[Client] 통 신 을  종 료 합 니 다 .")
        break

    # TCP 소켓 생성 및 서버 연결 (3-Way Handshake)
    clientSocket = socket(AF_INET, SOCK_STREAM)
    clientSocket.connect((serverName, serverPort))

    # 학번/이름 정보와 메시지 결합 후 전송
    full_sentence = f"[{student_id} {student_name}] {sentence}"
    clientSocket.send(full_sentence.encode())

    # 서버 응답 수신
    modifiedSentence = clientSocket.recv(1024)

    print(f"From Server: {modifiedSentence.decode()}\n")

    # 연결 종료
    clientSocket.close()
