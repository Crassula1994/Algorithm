package silver3.num25873;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 UCF 학생의 수를 변수 studentNum에 할당
		int studentNum = Integer.parseInt(in.readLine());
		
		// 선거에서 이길 가능성이 있는 회장-부회장 쌍의 개수를 저장할 변수 pairCnt 초기화
        long pairCnt = 0;
		
		// 알파벳별로 이름의 개수를 저장할 배열 nameCounts 초기화
		Map<String, Integer>[] nameCounts = new HashMap[26];
		
		// for 반복문을 사용해 각 알파벳별로 이름의 개수를 저장할 Map 객체 초기화
		for (int idx = 0; idx < nameCounts.length; idx++)
			nameCounts[idx] = new HashMap<>();
        
        // while 반복문을 사용해 각 학생의 이름을 순회
        while (studentNum-- > 0) {
        	
        	// readLine() 메서드를 사용해 입력 받은 학생의 이름을 변수 name에 할당
        	String name = in.readLine();
        	
        	// charAt() 메서드를 사용해 해당 학생의 이름을 저장할 위치를 변수 index에 할당
        	int index = name.charAt(0) - 'A';
        	
        	// getOrDefault() 및 put() 메서드를 사용해 해당 학생의 이름의 개수를 배열 nameCounts에 저장
        	nameCounts[index].put(name, nameCounts[index].getOrDefault(name, 0) + 1);
        }
        
        // for 반복문을 사용해 이름의 첫 알파벳을 순회
        for (int idx = 0; idx < nameCounts.length; idx++) {
        	
        	// 해당 알파벳을 가진 이름의 개수가 2개 미만인 경우 다음 알파벳을 순회
        	if (nameCounts[idx].size() < 2)
        		continue;
        	
        	// 해당 알파벳으로 시작하는 이름의 총 개수를 저장할 변수 totalCount 초기화
        	int totalCount = 0;
        	
        	// 해당 알파벳을 가진 이름별 개수를 저장할 List 객체 counts 초기화
            List<Integer> counts = new ArrayList<>();

            // for 반복문을 사용해 각 이름별 개수를 counts에 저장 후 해당 알파벳으로 시작하는 이름의 총 개수를 갱신
            for (int count : nameCounts[idx].values()) {
                counts.add(count);
                totalCount += count;
            }

            // for 반복문을 사용해 선거에서 이길 가능성이 있는 회장-부회장 쌍의 개수를 갱신
            for (int count : counts)
                pairCnt += count * (totalCount - count);
        }
        
        // valueOf() 및 write() 메서드를 사용해 선거에서 이길 가능성이 있는 회장-부회장 쌍의 개수를 출력
        out.write(String.valueOf(pairCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}