import cv2
import time

camera = cv2.VideoCapture(0)		
camera.set(cv2.CAP_PROP_BUFFERSIZE, 10)

ret, frame = camera.read()
cv2.imshow("first frame", frame)

time.sleep(10)

bufferSize = camera.get(cv2.CAP_PROP_BUFFERSIZE)
while(bufferSize > 0):
	camera.grab()
	bufferSize -= 1

ret, frame = camera.read()
cv2.imshow("after 10 secends", frame)

cv2.waitKey(0)
cv2.destroyAllWindows()
