package silver2.num20950;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 물감의 개수 및 곰두리색과 문두리색의 차이를 저장할 각 변수 초기화
	static int colorNum;
	static int minDifference = Integer.MAX_VALUE; 
	
	// 입력 받은 물감의 정보를 저장할 배열 colors 초기화
	static Color[] colors;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Color 클래스 정의
	static class Color {
		
		// 색상의 RGB 값을 저장할 각 변수 초기화
		int red;
		int green;
		int blue;
		
		// 매개변수를 입력 받는 생성자 정의
		public Color(int red, int green, int blue) {
			this.red = red;
			this.green = green;
			this.blue = blue;
		}
		
		// add() 메서드 정의
		public void add(Color otherColor) {
			
			// 두 색상을 더한 RGB 값을 저장
			this.red += otherColor.red;
			this.green += otherColor.green;
			this.blue += otherColor.blue;
		}
		
		// add() 메서드 정의
		public void subtract(Color otherColor) {
			
			// 두 색상을 뺀 RGB 값을 저장
			this.red -= otherColor.red;
			this.green -= otherColor.green;
			this.blue -= otherColor.blue;
		}
		
		// getDifference() 메서드 정의
		public int getDifference(Color mixedColor, int mixedCnt) {
			
			// 곰두리색과 섞은 물감의 색상 차이를 저장할 변수 difference 초기화
			int difference = 0;
			
			// abs() 메서드를 사용해 곰두리색과 섞은 물감의 색상 차이를 갱신
			difference += Math.abs(this.red - mixedColor.red / mixedCnt);
			difference += Math.abs(this.green - mixedColor.green / mixedCnt);
			difference += Math.abs(this.blue - mixedColor.blue / mixedCnt);
			
			// 곰두리색과 섞은 물감의 색상 차이를 반환
			return difference;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 물감의 개수를 변수 colorNum에 할당
		colorNum = Integer.parseInt(in.readLine());
		
		// 입력 받은 물감의 정보를 저장할 배열 colors 초기화
		colors = new Color[colorNum + 1];
		
		// for 반복문을 사용해 각 물감의 정보를 순회
		for (int idx = 0; idx < colors.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받는 물감의 정보를 각 변수에 할당
			int red = Integer.parseInt(st.nextToken());
			int green = Integer.parseInt(st.nextToken());
			int blue = Integer.parseInt(st.nextToken());
			
			// 입력 받은 물감의 정보를 배열 colors에 저장
			colors[idx] = new Color(red, green, blue);
		}
		
		// colorMixer() 메서드를 호출해 곰두리색과 문두리색의 차이를 갱신
		colorMixer(0, 0, new Color(0, 0, 0));
		
		// valueOf() 및 write() 메서드를 사용해 곰두리색과 문두리색의 차이를 출력
		out.write(String.valueOf(minDifference));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// colorMixer() 메서드 정의
	public static void colorMixer(int curColor, int mixedCnt, Color mixedColor) {
		
		// 물감을 2개 이상으로 섞은 경우 곰두리색과 문두리색의 차이를 갱신
		if (mixedCnt >= 2)
			minDifference = Math.min(colors[colorNum].getDifference(mixedColor, mixedCnt), minDifference);
		
		// 모든 색상을 확인하거나 혼합한 경우 메서드 종료
		if (curColor >= colorNum || mixedCnt >= 7)
			return;
		
		// 해당 색상을 섞지 않은 것으로 상정해 colorMixer() 메서드 재귀 호출
		colorMixer(curColor + 1, mixedCnt, mixedColor);
		
		// add() 메서드를 사용해 해당 색상을 섞은 것으로 처리
		mixedColor.add(colors[curColor]);
		
		// 해당 색상을 섞은 것으로 상정해 colorMixer() 메서드 재귀 호출
		colorMixer(curColor + 1, mixedCnt + 1, mixedColor);
		
		// subtract() 메서드를 사용해 해당 색상을 섞지 않은 것으로 처리
		mixedColor.subtract(colors[curColor]);
	}
}