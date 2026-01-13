package bronze1.num11580;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

// Main 클래스 정의
public class Main {
	
	// Footprint 클래스 정의
	static class Footprint {
		
		// 주현이의 발자국 좌표를 나타낼 각 변수 초기화
		int coordinateX;
		int coordinateY;
		
		// 매개변수를 입력 받는 생성자 정의
		public Footprint(int coordinateX, int coordinateY) {
			this.coordinateX = coordinateX;
			this.coordinateY = coordinateY;
		}
		
		// equals() 메서드 정의
		@Override
		public boolean equals(Object object) {
			
			// 비교 대상이 자기 자신인 경우 true 반환
			if (this == object)
				return true;
			
			// 비교 대상이 null이거나 클래스가 다른 경우 false 반환
			if (object == null || getClass() != object.getClass())
				return false;
			
			// 비교 대상을 Footprint 클래스로 형 변환하여 변수 otherFootprint에 할당
			Footprint otherFootprint = (Footprint) object;
			
			// 두 좌표가 같은지 여부를 반환
			return this.coordinateX == otherFootprint.coordinateX
					&& this.coordinateY == otherFootprint.coordinateY;
		}
		
		// hashCode() 메서드 정의 
		@Override
		public int hashCode() {
			
			// 해시코드 결과를 저장할 변수 result 초기화
			int result = 17;
			
			// 각 좌표의 위치를 해시코드 결과에 반영
			result = 31 * result + this.coordinateX;
			result = 31 * result + this.coordinateY;
			
			// 좌표의 위치를 반영한 해시코드 결과를 반환
			return result;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 명령어의 길이 및 명령어를 각 변수에 할당
		int commandLength = Integer.parseInt(in.readLine());
		String commandString = in.readLine();
		
		// 재윤이의 현재 위치 좌표를 저장할 각 변수 초기화
		int coordinateX = 0;
		int coordinateY = 0;
		
		// 재윤이의 발자국이 찍힌 위치를 저장할 Set 객체 footprints 초기화
		Set<Footprint> footprints = new HashSet<>();
		
		// add() 메서드를 사용해 footprints에 원점을 추가
		footprints.add(new Footprint(coordinateX, coordinateY));
		
		// for 반복문을 사용해 각 명령어를 순회
		for (int idx = 0; idx < commandLength; idx++) {
			
			// charAt() 메서드를 사용해 해당 명령어를 변수 command에 할당
			char command = commandString.charAt(idx);
			
			// switch 조건문을 사용해 재윤이의 현재 위치 좌표를 갱신
			switch (command) {
				case 'E':
					coordinateX++;
					break;
				case 'W':
					coordinateX--;
					break;
				case 'S':
					coordinateY--;
					break;
				default:
					coordinateY++;
			}
			
			// add() 메서드를 사용해 footprints에 발자국이 찍힌 좌표를 추가
			footprints.add(new Footprint(coordinateX, coordinateY));
		}
		
		// size(), valueOf(), write() 메서드를 사용해 좌표평면 위에 찍힌 재윤이의 발자국의 수를 출력
		out.write(String.valueOf(footprints.size()));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}