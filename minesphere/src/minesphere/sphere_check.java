package minesphere;

public class sphere_check {
	static boolean isVoxel(float rad, float x, float y, float z, int n) { 
		float tempx, tempy, tempz, value;
		value = 0;
		int count = n-1;
		for(int i = 0; i < n; i++) {
			tempx = x - (float)i/count;
			for(int j = 0; j < n; j++) {
				tempy = y - (float)j/count;
				for (int k = 0; k < n; k++) {
					tempz = z - (float)k/count;
					float zMod = 1f - (float)k/count;
					if(isInside(tempx, tempy, tempz, rad)) {
						value = value + zMod/(n*n);
						//System.out.println(value + " " + tempx + "," + tempy+ "," + tempz);
						break;
					}else {
						//System.out.println("Outside" + " " + tempx + "," + tempy+ "," + tempz);
					}
				}
			}
		}
		if(value >= 0.5) {
			return true;
		}else {
			return false;
		}
	}
	
	static boolean isInside(float tempx,float tempy,float tempz,float rad) {
		if (tempx * tempx + tempy * tempy + tempz * tempz <= rad * rad) 
			return true; 
			else
			return false; 
	}

// Driver Program to test above function 
	public static void main(String arg[]) { 
		float x = 3, y = 1, z = 1, rad = 3;
		int n = 3;
		int[][] sphere = new int[(int)rad][(int)rad];
		for(x=1; x < rad; x++) {
			for(y=1;y < rad; y++) {
				for(z=rad;z > 1;z--) {
					if(isVoxel(rad, x, y, z, n)) {
						sphere[(int)x][(int)y] = (int)z;
					}
				}
			}
		}
	for(int i = 0; i<(int)rad; i++)
	{
	    for(int j = 0; j<(int)rad; j++)
	    {
	        System.out.print(sphere[i][j]);
	    }
	    System.out.println();
		}
	}
}
