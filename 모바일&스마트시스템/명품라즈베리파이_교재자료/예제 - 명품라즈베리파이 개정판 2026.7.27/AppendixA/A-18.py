students = {"jmlee": [88, 97, 50], "kitae": [90, 80], "ihjung": [99, 70, 60]}

cmd = input("high 또는 low를 입력하세요>> ")

if cmd == "high":
	high = 0
	for name in students.keys( ):
		scores = students[name]
		for score in scores:
			high = score if high < score else high
	print("최고 점수는 %d입니다." % high)
else:
	low = 100
	for name in students.keys( ):
		scores = students[name]
		for score in scores:
			low = score if low > score else low
	print("최저 점수는 %d입니다." % low)

