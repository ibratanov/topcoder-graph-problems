package com.topcoder.grafixMask
import java.util.*

class grafixMask {
	void main() {
		def grid = new boolean[50][50]
		def Rectangles = initializeRectangles()
	}
	
	Rectangle[] initializeRectangles() {
		def Rectangles = new Rectangle[4]
		Rectangles[0] = new Rectangle(0,2,0,2)
		Rectangles[1] = new Rectangle(0,1,5,7)
		Rectangles[2] = new Rectangle(10,16,16,19)
		Rectangles[3] = new Rectangle(30,33,30,43)
	}
}

class Rectangle {
	def left, right, top, bottom
	public Rectangle(l, r, t, b) {
		this.left = l
		this.right = r
		this.top = t
		this.bottom = b
	}
}