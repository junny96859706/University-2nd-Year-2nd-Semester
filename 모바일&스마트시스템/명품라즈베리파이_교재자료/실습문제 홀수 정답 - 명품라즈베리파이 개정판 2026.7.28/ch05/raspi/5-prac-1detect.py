import os, time, cv2
from ultralytics import YOLO
import camera

MODEL, CONF, IMGSZ = "yolov8n.pt", 0.60, 640
CAM, W, H = 0, 640, 480

if not os.environ.get("DISPLAY"): os.environ["DISPLAY"] = ":0"

start_time, counter = time.time(), 0 # fps를 위한 초기화

def draw_fps(frame):                            # FPS 화면 표시 함수
    global counter
    counter += 1; fps = counter / (time.time() - start_time)
    cv2.putText(frame, f"FPS:{fps:.1f}", (10,90), 0, 0.8, (255,255,0), 2)

def draw_detections(frame, result, conf=CONF):
    if result.boxes is None: return frame
    count = 0                                         # 사람 수 초기화
    for b in result.boxes:
        if float(b.conf[0]) < conf: continue
        cls = int(b.cls[0])
        cls_name = result.names.get(cls, '')
        if cls_name != 'person': continue     # person만 처리
        count += 1
        x1,y1,x2,y2 = map(int, b.xyxy[0].tolist())
        label = f"person {float(b.conf[0]):.2f}"
        cv2.rectangle(frame, (x1,y1), (x2,y2), (255,0,0), 2)  # 파란색
        (tw,th),_ = cv2.getTextSize(label, 0, 0.6, 2)
        y = max(0, y1-8)
        cv2.rectangle(frame, (x1,y-th-6), (x1+tw+6,y), (255,0,0), -1)
        cv2.putText(frame, label, (x1+3,y-5), 0, 0.6, (0,0,0), 2)
    # 화면 상단에 인원 수 표시
    cv2.putText(frame, f"Person: {count}", (10,30), 0, 0.8, (255,0,0), 2)
    return frame

def main():
    model = YOLO(MODEL)
    camera.init(CAM, W, H, buffer_size=1)
    while True:
        frame = camera.read()
        if frame is None: time.sleep(0.05); continue
        results = model.predict(source=frame, imgsz=IMGSZ, conf=CONF, device="cpu", verbose=False)
        vis = draw_detections(frame.copy(), results[0])
        draw_fps(vis)
        cv2.imshow("Person Detector (q=quit)", vis)
        if cv2.waitKey(1) & 0xFF == ord("q"): break
    camera.release()
    cv2.destroyAllWindows()

if __name__ == "__main__":
    main()