list = [1, 2, "jmlee", 3] 	# 리스트 만들기
print(list)
list.append(4) 		# 마지막 원소로 4 추가
print(list)

list.insert(3, "d") 		# 인덱스 3위치에 "d" 추가
print(list)
list[list.index("jmlee")] = 10 	# "jmee"를 10으로 수정
list.remove("d") 		# "d" 원소 삭제
print(list)

list.sort(reverse = True) 	# 내림차순으로 정렬
print(list)
print("원소의 개수 = %d" % len(list)) # 원소 개수

