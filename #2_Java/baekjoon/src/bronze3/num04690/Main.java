package bronze3.num04690;

// 필요한 패키지 불러오기
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedWriter 객체를 불러와 변수 out에 할당
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 각 자연수의 세제곱 값을 저장할 배열 cubes 초기화
		int[] cubes = new int[101];
		
		// for 반복문을 사용해 2부터 100까지의 세제곱 값을 갱신
		for (int idx = 2; idx < cubes.length; idx++)
			cubes[idx] = idx * idx * idx;
		
		// for 반복문을 사용해 각 자연수를 순회
		for (int numberA = 6; numberA <= 100; numberA++) {
			for (int numberB = 2; numberB <= 100; numberB++) {
				for (int numberC = numberB + 1; numberC <= 100; numberC++) {
					for (int numberD = numberC + 1; numberD <= 100; numberD++) {
						
						// 우변의 값을 계산해 변수 cubeSum에 할당
						int cubeSum = cubes[numberB] + cubes[numberC] + cubes[numberD];
						
						// 좌변과 우변의 값이 일치하는 경우 정해진 형식으로 출력
						if (cubes[numberA] == cubeSum)
							out.write("Cube = " + numberA + ", Triple = (" + numberB + "," + numberC + "," + numberD + ")\n");
						
						// 좌변보다 우변의 값이 커진 경우 반복문 탈출
						if (cubeSum > cubes[numberA])
							break;
					}
				}
			}
		}
		
		// close() 메서드를 사용해 BufferedWriter 객체 종료
		out.close();
	}
}