import cv2
import time

camera = cv2.VideoCapture(0)		
camera.set(cv2.CAP_PROP_BUFFERSIZE, 10)

ret, frame = camera.read()
cv2.imshow("first frame", frame)

time.sleep(10)
ret, frame = camera.read()

cv2.imshow("after 10 seconds", frame)

cv2.waitKey(0)
cv2.destroyAllWindows()
