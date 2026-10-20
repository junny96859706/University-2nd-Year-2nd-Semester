n = input("정수 입력>> ")
n = int(n) # 입력받은 문자열을 정수로 변환
i = 1
sum = 0
while i <= n :
	sum += i
	i += 1
print("1~%d까지의 합은 %d" % (n, sum))

