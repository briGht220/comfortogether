import cv2
from line_recognize import RecognizeLine
from object_detect import DetectObject
from send_img import SendImg
import numpy as np

find_line = RecognizeLine()
find_object = DetectObject()


def main():
    img = SendImg()
    img = cv2.imread(img)
    copy = img.copy()
    
    #line recogize
    edge = find_line.DectectEdge(copy)
    mask = find_line.RegionOfInterest(edge)
    signal, copy = find_line.HoughLines(mask, 2, np.pi/180, 90, 120, 150)
    
    #object detect
    classesFile = "coco.names"
    classes = find_object.class_file(classesFile)

    modelWeights = "best.onnx"
    net = cv2.dnn.readNet(modelWeights)
      
    detections = find_object.pre_process(copy, net)
    img, label = find_object.post_process(copy.copy(), detections, classes)

    return signal, label
   
if __name__ == "__main__":
	main()
