package gold5.num15591;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 동영상의 개수를 저장할 변수 videoNum 초기화
	static int videoNum;
	
	// 각 동영상 사이의 USADO를 저장할 배열 mooTube 초기화
	static List<int[]>[] mooTube;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 동영상의 개수 및 질문의 개수를 각 변수에 할당
		videoNum = Integer.parseInt(st.nextToken());
		int questionNum = Integer.parseInt(st.nextToken());
		
		// 각 동영상 사이의 USADO를 저장할 배열 mooTube 초기화
		mooTube = new ArrayList[videoNum + 1];
		
		// for 반복문을 사용해 각 동영상 사이의 USADO를 저장할 List 객체 초기화
		for (int idx = 0; idx < mooTube.length; idx++)
			mooTube[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 동영상 쌍을 순회
		for (int pair = 0; pair < videoNum - 1; pair++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 연결된 동영상과 USADO를 각 변수에 할당
			int startVideo = Integer.parseInt(st.nextToken());
			int endVideo = Integer.parseInt(st.nextToken());
			int usado = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 해당 동영상 쌍의 USADO를 배열 mooTube에 저장
			mooTube[startVideo].add(new int[] {endVideo, usado});
			mooTube[endVideo].add(new int[] {startVideo, usado});
		}
		
		// while 반복문을 사용해 각 질문을 순회
		while (questionNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 추천할 기준이 될 동영상과 기준 USADO를 각 변수에 할당
			int minUsado = Integer.parseInt(st.nextToken());
			int startVideo = Integer.parseInt(st.nextToken());
			
			// videoRecommender() 메서드를 호출해 추천될 동영상의 수를 변수 count에 할당
			int count = videoRecommender(minUsado, startVideo);
			
			// write() 메서드를 사용해 추천될 동영상의 수를 출력
			out.write(count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// videoRecommender() 메서드 정의
	public static int videoRecommender(int minUsado, int startVideo) {
		
		// 추천될 동영상의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// 각 동영상의 USADO를 저장할 배열 usados 초기화
		Integer[] usados = new Integer[videoNum + 1];
		
		// 다음에 확인할 동영상을 저장할 Queue 객체 videoList 초기화
		Queue<Integer> videoList = new LinkedList<>();
		
		// offer() 메서드를 사용해 기준이 될 동영상을 videoList에 추가 후 계산 처리
		videoList.offer(startVideo);
		usados[startVideo] = Integer.MAX_VALUE;
		
		// while 반복문을 사용해 videoList가 빌 때까지 순회
		while (!videoList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 동영상을 변수 curVideo에 할당
			int curVideo = videoList.poll();
			
			// for 반복문을 사용해 현재 동영상과 연결된 다른 동영상을 순회
			for (int[] nextVideo : mooTube[curVideo]) {
				
				// 이전에 확인한 동영상인 경우 다음 동영상을 순회
				if (usados[nextVideo[0]] != null)
					continue;
				
				// min() 메서드를 사용해 현재 동영상과 연결된 동영상의 USADO를 변수 nextUsado에 할당
				int nextUsado = Math.min(usados[curVideo], nextVideo[1]);
				
				// 현재 동영상과 연결된 동영상의 USADO가 기준 USADO 미만인 경우 다음 동영상을 순회
				if (nextUsado < minUsado)
					continue;
				
				// offer() 메서드를 사용해 연결된 동영상을 videoList에 추가 후 계산 처리
				videoList.offer(nextVideo[0]);
				usados[nextVideo[0]] = nextUsado;
				
				// 추천될 동영상의 수를 갱신
				count++;
			}
		}
		
		// 추천될 동영상의 수를 반환
		return count;
	}
}