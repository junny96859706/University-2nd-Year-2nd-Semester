i = 1
sum = 0
while True :
	sum += i
	if sum > 3000:
		break # 합이 3000을 넘어섰기 때문에 반복 종료
	i += 1
print("1~%d까지 합하면 %d입니다." % (i, sum))

