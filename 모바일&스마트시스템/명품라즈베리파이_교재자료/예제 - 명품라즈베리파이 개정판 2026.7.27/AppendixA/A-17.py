dict = {"jmlee": 88, "kitae": 98, "ihjung":99}

cmd = input("high 또는 low를 입력하세요>> ")

names = list(dict.keys( ))
scores = list(dict.values( ))
if cmd == "high":
	high = 0
	for i in range(len(names)):
		high = scores[i] if high < scores[i] else high
	print("최고 점수는 %d입니다." % high)
if cmd == "low":
	low = 100
	for i in range(len(names)):
		low = scores[i] if low > scores[i] else low
	print("최저 점수는 %d입니다." % low)

value = dict.get("gdhong")
print(value)

