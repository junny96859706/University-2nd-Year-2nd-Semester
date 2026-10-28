from socket import *

student_id = "2371214"
student_name = "이 지 형 "

serverPort = 12000

# TCP 소켓 생성 (SOCK_STREAM 사용)
serverSocket = socket(AF_INET, SOCK_STREAM)
serverSocket.bind(('', serverPort))

# 클라이언트의 연결 요청 대기 (웰커밍 소켓 활성화)
serverSocket.listen(1)

print("==========================================")
print(f" TCP Server Started by [{student_id} {student_name}]")
print(f" The server is ready to receive (Port: {serverPort})")
print("==========================================\n")

while True:
    # 클라이언트의 연결 요청 수락 (전용 연결 소켓 생성)
    connectionSocket, addr = serverSocket.accept()
    
    # 데이터 수신 및 디코딩
    sentence = connectionSocket.recv(1024).decode()
    
    # 서버 터미널 로그 출력 (캡처용)
    print(f"[Received from {addr}]: {sentence}")
    
    # 대문자 변환 후 연결된 클라이언트로 전송
    capitalizedSentence = sentence.upper()
    connectionSocket.send(capitalizedSentence.encode())
    
    # 해당 클라이언트와의 연결 종료
    connectionSocket.close()
