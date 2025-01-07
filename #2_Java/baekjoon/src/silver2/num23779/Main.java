package silver2.num23779;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 화성과 실버스타 소행성 사이의 거리를 변수 totalDist에 할당
		int totalDist = Integer.parseInt(in.readLine());
			
		// 각 소행성까지 이동하는 무인 우주 탐사선의 궤도의 수를 저장할 배열 counts 초기화
		long[] counts = new long[totalDist + 1];
		
		// asteroidFinder() 메서드를 호출해 화성과 실버스타 소행성 사이의 소행성을 저장한 List 객체 asteroids 초기화
		List<Integer> asteroids = asteroidFinder(totalDist);
			
		// 소행성까지의 거리가 2일 때 무인 우주 탐사선의 궤도의 수를 초기화
		counts[2] = 1;
		
		// for 반복문을 사용해 각 소행성을 순회
		for (int curIdx = 1; curIdx < asteroids.size(); curIdx++) {
			
			// get() 메서드를 사용해 현재 소행성의 거리를 변수 curAsteroid에 할당
			int curAsteroid = asteroids.get(curIdx);
			
			// for 반복문을 사용해 이전의 소행성을 순회
			for (int prevIdx = curIdx - 1; prevIdx >= 0; prevIdx--) {
				
				// get() 메서드를 사용해 이전 소행성의 거리를 변수 prevAsteroid에 할당
				int prevAsteroid = asteroids.get(prevIdx);
				
				// 소행성 사이의 거리가 14를 초과하는 경우 반복문 탈출
				if (curAsteroid - prevAsteroid > 14)
					break;
				
				// 현재 소행성까지 이동하는 무인 우주 탐사선의 궤도의 수를 갱신
				counts[curAsteroid] += counts[prevAsteroid];
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 실버스타 소행성까지 이동하는 무인 우주 탐사선의 궤도의 수를 출력
		out.write(String.valueOf(counts[totalDist]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// asteroidFinder() 메서드 정의
	public static List<Integer> asteroidFinder(int totalDist) {
		
		// 해당 숫자가 소수가 아닌지 여부를 저장할 배열 isNotPrime 초기화
		boolean[] isNotPrime = new boolean[totalDist + 1];
		
		// 화성과 실버스타 소행성 사이의 소행성을 저장할 List 객체 asteroids 초기화
		List<Integer> asteroids = new ArrayList<>();
		
		// for 반복문을 사용해 가능한 인수를 순회
		for (int factor = 2; factor <= totalDist; factor++) {
			
			// 해당 숫자가 소수가 아닌 경우 다음 숫자를 순회
			if (isNotPrime[factor])
				continue;
			
			// add() 메서드를 사용해 소수인 숫자를 asteroids에 저장
			asteroids.add(factor);
			
			// for 반복문을 사용해 해당 숫자의 배수에 대하여 소수가 아닌지 여부를 갱신
			for (int multiplier = factor * 2; multiplier <= totalDist; multiplier += factor)
				isNotPrime[multiplier] = true;
		}
		
		// 화성과 실버스타 소행성 사이의 소행성을 저장한 List 객쳋 반환
		return asteroids;
	}
}