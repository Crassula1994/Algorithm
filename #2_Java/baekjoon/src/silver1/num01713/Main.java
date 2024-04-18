package silver1.num01713;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Picture 클래스 정의
	public static class Picture implements Comparable<Picture> {
		
		// 해당 사진의 학생과 게시 순서, 추천 수를 저장할 각 변수 초기화
		int student;
		int order;
		int count;
		
		// 매개변수를 입력 받는 생성자 정의
		public Picture(int student, int order) {
			this.student = student;
			this.order = order;
			this.count = 1;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Picture otherPic) {
			
			// 추천 수가 같은 경우 먼저 게시된 순서대로 정렬
			if (count == otherPic.count)
				return order - otherPic.order;
			
			// 추천 수가 적은 순서대로 정렬
			return count - otherPic.count;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 사진틀의 개수 및 전체 학생의 총 추천 횟수를 각 변수에 할당
		int frameNum = Integer.parseInt(in.readLine());
		int totalCnt = Integer.parseInt(in.readLine());
		
		// 각 학생의 사진 게시 여부를 저장할 배열 posted 초기화
		boolean[] posted = new boolean[101];
		
		// 사진틀에 게시된 학생을 저장할 List 객체 frames 초기화
		List<Picture> frames = new LinkedList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 사진의 게시 순서를 저장할 변수 order 초기화
		int order = 0;
		
		// for 반복문을 사용해 각 학생의 추천 결과를 순회
		for (int result = 0; result < totalCnt; result++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 추천한 학생을 변수 student에 할당
			int student = Integer.parseInt(st.nextToken());
			
			// 해당 학생이 사진틀에 게시된 경우
			if (posted[student]) {
				
				// for 반복문을 사용해 사진틀의 각 사진을 순회
				for (Picture picture : frames) {
					
					// 해당 사진의 학생이 추천 받은 학생인 경우 추천 수를 갱신 후 반복문 탈출
					if (student == picture.student) {
						picture.count++;
						break;
					}
				}
			
			// 해당 학생이 사진틀에 게시되지 않은 경우
			} else {
				
				// 사진틀이 비어 있지 않은 경우
				if (frames.size() >= frameNum) {
					
					// get() 메서드를 사용해 제거할 사진을 변수 removedPic에 할당
					Picture removedPic = frames.get(0);
					
					// remove() 메서드를 사용해 사진틀에서 해당 사진을 제거
					frames.remove(0);
					
					// 제거한 사진의 학생에 대한 사진 게시 여부를 갱신
					posted[removedPic.student] = false;
				}
				
				// add() 메서드를 사용해 추천 받은 학생의 사진을 frames에 추가
				frames.add(new Picture(student, ++order));
				
				// 해당 학생의 사진 게시 여부를 갱신
				posted[student] = true;
			}
			
			// sort() 메서드를 사용해 프레임에 들어간 사진을 정렬
			Collections.sort(frames);
		}
		
		// for 반복문을 사용해 전체 학생의 번호를 순회
		for (int idx = 1; idx < posted.length; idx++) {
			
			// 해당 학생이 사진틀에 게시된 경우 해당 학생의 번호를 출력
			if (posted[idx])
				out.write(idx + " ");
		}
			
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}