import cv2
from line_recognize import RecognizeLine
#from send_img import SendImg
import numpy as np

find_line = RecognizeLine()

#working은 local에서 이미지로 돌릴 때
def working() :
    image_directory = 'C:/Users/dpffl/Desktop/comfortogether/img'
    images = find_line.read_images_with_extension(image_directory)
    for image in images :
        image = cv2.imread(image)
        img = image.copy()
        #print(img.shape)
        edge =  find_line.DectectEdge(img)
        mask = find_line.RegionOfInterest(edge)
        signal, img = find_line.HoughLines(mask, 2, np.pi/180, 90, 120, 150)
        print(signal)
        #return signal
        
#working()

def main():
    img = SendImg()
    img = cv2.imread(img)
    copy = img.copy()
    edge = find_line.DectectEdge(copy)
    mask = find_line.RegionOfInterest(edge)
    signal, copy = find_line.HoughLines(mask, 2, np.pi/180, 90, 120, 150)
    
    return signal
   
if __name__ == "__main__":
	main()
