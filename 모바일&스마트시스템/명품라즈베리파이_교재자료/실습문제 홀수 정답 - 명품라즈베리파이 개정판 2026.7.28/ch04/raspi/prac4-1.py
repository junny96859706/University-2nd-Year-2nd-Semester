import cv2
import time

camera = cv2.VideoCapture(0, cv2.CAP_V4L)

time.sleep(10)
print("촬영 시작")

bufferSize = camera.get(cv2.CAP_PROP_BUFFERSIZE)
while(bufferSize > 0):
	camera.grab()
	bufferSize -= 1

ret, image = camera.read()

if ret == True:
	cv2.imwrite("prac_image_4_1.jpg", image) # OpenCV 함수로 이미지를 파일에 저장
else:
	print("카메라로부터 프레임의 캡쳐할 수 없습니다.")
camera.release()

