def find_max_length(arr): # 배열에서 가장 긴 문자열을 리턴
	
	max_len_elm = arr[0]
	for i in range(1, len(arr)):
		if len(max_len_elm) < len(arr[i]):
			max_len_elm = arr[i]
	return max_len_elm

names = ["SonHeungmin", "HwangHeechan",	"ParkSung", "HongSuhon", "HongMyungbo"]	

print("예제 문자열: ", end="")
for name in names:
	print(name, end=" ")

print("\n가장 긴 문자열: %s" % find_max_length(names))
