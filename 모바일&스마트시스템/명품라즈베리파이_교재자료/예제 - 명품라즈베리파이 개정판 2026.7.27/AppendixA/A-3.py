ten = int("10") 		# ten = 10과 같은 결과
twenty = int(20.5) 	# twenty = 20과 같은 결과
text1 = str(30) 		# text1 = "30"과 같은 결과
text2 = str(40.5) 		# text2 = "40.5"
a = chr(65) 		# a = "A"와 같은 결과. 65는 문자 A에 대한 ASCII 코드
b = ord("A") 		# b = 65와 같은 결과. 문자 A의 ASCII 코드는 65
c = bool(0) 		# c = False과 같은 결과
d = bool("True") 		# d = True와 같은 결과
print("ten=%d, twenty=%d" % (ten, twenty))
print("text1=%s, text2=%s" % (text1, text2))
print("a=%s, b=%d, c=%d, d=%d" % (a, b, c, d))

