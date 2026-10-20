names = ["손흥민", "황희찬", "박항서", "유상철", "김남일"]
file = open("myfile.txt", "w") # 쓰기 모드로 myfile.txt 파일 열기. myfile.txt가 없으면 생성

for i in range(0, len(names)): # len(names)가 5이므로 5번 반복
	line = "%d번째 이름 %s\n" % (i, names[i])
	file.write(line) # 파일 쓰기
file.close( ) # 파일 닫기. 다시 열기 전에는 쓸 수 없음

# 파일 열기
file = open("myfile.txt", "r") # 읽기 모드로 myfile.txt 파일 열기. myfile.txt 파일이 없으면 예외 발생
for line in file.readlines( ): # 파일에서 각 라인을 반복하여 line 변수에 읽음
	print(line, end="") # 읽은 라인을 화면에 출력

file.close( ) # 파일 닫기. 다시 열기 전에는 읽을 수 없음

