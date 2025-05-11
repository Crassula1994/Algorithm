package silver1.num14426;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Node 클래스 정의
	static class Node {
		
		// 해당 글자가 마지막인지 여부를 나타낼 변수 isEnd 초기화
		boolean isEnd;
		
		// 다음에 올 글자를 저장할 Map 객체 nextNodes 초기화
		Map<Character, Node> nextNodes;
		
		// 생성자 정의
		public Node() {
			isEnd = false;
			nextNodes = new HashMap<>();
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// 문자열을 저장할 집합을 나타낼 Node 객체를 저장할 변수 rootNode 초기화
	static Node rootNode = new Node();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 집합에 속한, 그리고 입력으로 주어질 문자열의 개수를 각 변수에 할당
		int size = Integer.parseInt(st.nextToken());
		int inputCnt = Integer.parseInt(st.nextToken());
		
		// 입력으로 주어진 문자열이 집합에 속한 문자열의 접두어인 경우의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 집합에 속한 문자열을 순회
		for (int element = 0; element < size; element++) {
			
			// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
			String string = in.readLine();
			
			// stringInserter() 메서드를 호출해 입력 받은 문자열을 집합에 저장
			stringInserter(string);
		}
		
		// for 반복문을 사용해 각 입력으로 주어진 문자열을 순회
		for (int input = 0; input < inputCnt; input++) {
			
			// readLine() 메서드를 사용해 입력 받은 문자열을 변수 prefix에 할당
			String prefix = in.readLine();
			
			// 입력 받은 문자열이 접두어인 경우 그 경우의 수를 갱신
			if (prefixFinder(prefix))
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 입력으로 주어진 문자열이 집합에 속한 문자열의 접두어인 경우의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// stringInserter() 메서드 정의
	public static void stringInserter(String string) {
		
		// 현재 글자를 나타낼 Node 객체를 저장할 변수 curNode 초기화
		Node curNode = rootNode;
		
		// for 반복문을 사용해 문자열의 각 글자를 rootNode에 저장
		for (char alphabet : string.toCharArray())
			curNode = curNode.nextNodes.computeIfAbsent(alphabet, _key -> new Node());
		
		// 마지막 글자의 위치를 갱신
		curNode.isEnd = true;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// prefixFinder() 메서드 정의
	private static boolean prefixFinder(String prefix) {
		
		// 현재 글자를 찾을 Node 객체를 저장할 변수 curNode 초기화
		Node curNode = rootNode;
		
		// for 반복문을 사용해 문자열의 각 글자를 순회
		for (char alphabet : prefix.toCharArray()) {
			
			// 해당 글자가 존재하지 않는 경우 false 반환
			if (!curNode.nextNodes.containsKey(alphabet))
				return false;
			
			// get() 메서드를 사용해 다음 글자를 찾을 Node 객체를 갱신
			curNode = curNode.nextNodes.get(alphabet);
		}
		
		// 모든 글자가 차례로 존재하는 경우 true 반환
		return true;
	}
}