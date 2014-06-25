package com.topcoder.grafixMask
import java.util.*

class grafixMask {
	public static void main(String[] args) {
		def grid = initializeEmptyGrid(50, 50)
		def rectangles = initializeRectangles()
		
		grid = initializeGridWithRectangles(grid, rectangles)
	}
	
	static boolean[][] initializeEmptyGrid(int ht, int wid) {
		def grid = new boolean[ht][wid]
		for (int i = 0; i < ht; i++) {
			for (int j = 0; j < wid; j++) {
				grid[i][j] = false
			}
		}
		return grid
	}
	
	static Rectangle[] initializeRectangles() {
		def rectangles = new Rectangle[4]
		rectangles[0] = new Rectangle(0,2,0,2)
		rectangles[1] = new Rectangle(0,1,5,7)
		rectangles[2] = new Rectangle(10,16,16,19)
		rectangles[3] = new Rectangle(30,33,30,43)
		
		return rectangles
	}
	
	static boolean[][] initializeGridWithRectangles(boolean[][] grid, Rectangle[] rectangles) {
		for (rectangle in rectangles) {
			for (int i = rectangle.top; i <= rectangle.bottom; i++) {
				for (int j = rectangle.left; j <= rectangle.right; j++) {
					grid[i][j] = true
				}
			}
		}
		return grid
	}
	
}

class Rectangle {
	def left, right, top, bottom
	public Rectangle(int l, int r, int t, int b) {
		this.left = l
		this.right = r
		this.top = t
		this.bottom = b
	}
}