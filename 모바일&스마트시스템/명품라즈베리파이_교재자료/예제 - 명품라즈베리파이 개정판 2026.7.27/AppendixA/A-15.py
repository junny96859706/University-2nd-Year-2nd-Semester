print("1~10사이 3으로 나눈 나머지가 1인 수만 더하기")
print("-----------------------------------")
sum = 0
for i in range(1, 11): # i가 1에서 10까지 반복
	if (i % 3) != 1:
		continue
	print(i, end = " ")
	sum += i
print("의 합은 %d" % sum)

