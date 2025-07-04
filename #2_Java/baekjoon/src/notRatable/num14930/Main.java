package notRatable.num14930;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Bead 클래스 정의
	static class Bead implements Comparable<Bead> {
		
		// 해당 구슬의 위치와 초속도, 빨간 구슬인지 여부를 저장할 각 변수 초기화
		long position;
		long velocity;
		boolean isRed;
		
		// 매개변수를 입력 받는 생성자 정의
		public Bead(long position, long velocity, boolean isRed) {
			this.position = position;
			this.velocity = velocity;
			this.isRed = isRed;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Bead anotherBead) {
			
			// compare() 메서드를 사용해 구슬의 위치를 기준으로 오름차순 정렬
			return Long.compare(this.position, anotherBead.position);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 구슬의 개수 및 시간을 각 변수에 할당
		int beadNum = Integer.parseInt(st.nextToken());
		int targetTime = Integer.parseInt(st.nextToken());
		
		// 빨간색 구슬의 위치를 저장할 변수 targetIdx 초기화
		int targetIdx = -1;
		
		// 각 구슬의 정보 및 시간이 지난 후 위치를 저장할 각 배열 초기화
		Bead[] beads = new Bead[beadNum];
		long[] finalPositions = new long[beadNum];
		
		// for 반복문을 사용해 각 구슬의 정보를 순회
		for (int idx = 0; idx < beads.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 구슬의 위치와 초속도를 각 변수에 할당
			long position = Integer.parseInt(st.nextToken());
			long velocity = Integer.parseInt(st.nextToken());
			
			// 해당 구슬의 정보를 배열 beads에 저장
			beads[idx] = new Bead(position, velocity, idx == 0);
		}
		
		// sort() 메서드를 사용해 구슬의 현재 위치를 기준으로 오름차순 정렬
		Arrays.sort(beads);
		
		// for 반복문을 사용해 각 구슬을 순회
		for (int idx = 0; idx < beads.length; idx++) {
			
			// 현재 구슬을 변수 bead에 할당
			Bead bead = beads[idx];
			
			// 해당 구슬의 시간이 지난 후의 위치를 배열 finalPositions에 저장
			finalPositions[idx] = bead.position + bead.velocity * targetTime;
			
			// 해당 구슬이 빨간색인 경우 빨간색 구슬의 위치를 갱신
			if (bead.isRed)
				targetIdx = idx;
		}
		
		// sort() 메서드를 사용해 시간이 지난 후 구슬의 위치를 오름차순 정렬
		Arrays.sort(finalPositions);
		
		// valueOf() 및 write() 메서드를 사용해 시간이 지난 후 빨간 구슬의 위치를 출력
		out.write(String.valueOf(finalPositions[targetIdx]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}