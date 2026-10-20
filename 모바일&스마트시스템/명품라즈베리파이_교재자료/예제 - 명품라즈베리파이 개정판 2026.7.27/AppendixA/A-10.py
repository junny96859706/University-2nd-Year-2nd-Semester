grade = 0
score = input("점수를 입력하세요>>")
score = int(score) # 문자열을 숫자로 바꿈
if score >= 90 : 		# score가 90 이상
	grade = "A"
elif score >= 80 : 		# 80 이상 90 미만
	grade = "B"
elif score >= 70 : 		# 70 이상 80 미만
	grade = "C"
elif score >= 60 : 		# 60 이상 70 미만
	grade = "D"
else: 			# 60 미만
	grade = "F"
print(str(score) + "는 " + grade + "입니다.")

