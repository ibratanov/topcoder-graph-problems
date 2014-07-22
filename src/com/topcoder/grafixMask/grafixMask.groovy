package com.topcoder.grafixMask
import java.util.*

class grafixMask {
	public static void main(String[] args) {
		def grid = initializeEmptyGrid(500, 500)
		def rectangles = initializeRectangles()
		
		grid = initializeGridWithRectangles(grid, rectangles)
		printGrid(grid)
		
		int rectangleCount = 0
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == true) {
					int thisRect = countRectangles(grid, i, j)
					if (thisRect > 0) {
					rectangleCount++
					println("One rectangle of size: " + thisRect)
					}
				}
			}
		}
		println("Final count: " + rectangleCount);
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
		rectangles[3] = new Rectangle(0,330,0,430)
		
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
	
	static int countRectangles(boolean[][] grid, int i, int j) {
		// Check to ensure that we are within the bounds of the grid, if not, return 0
		if (i < 0 || i >= grid.length) return 0;
	   // Similar check for y
		if (j < 0 || j >= grid[i].length) return 0;
		// Check if there's a rectangle at this position, and that we haven't already visited this position, as we don't want to count it twice
		if (!grid[i][j]) return 0;
		
		grid[i][j] = false;
		
		// Now we know that we've found at least one node in a rectangle, then we will recursively attempt to
		// visit every node adjacent to this node, and add those results together to return.
		return 1 + countRectangles(grid, i - 1, j) + countRectangles(grid, i + 1, j) + countRectangles(grid, i, j + 1) + countRectangles(grid, i, j - 1);
		
	}
	
	static void printGrid(boolean[][] grid) {
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == true) {
					print("1")
				} else {
					print("0")
				}
			}
			println()
		}
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