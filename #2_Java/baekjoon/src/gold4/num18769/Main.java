package gold4.num18769;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 서버의 대표 서버를 저장할 배열 rootServer 초기화
	static int[] rootServer;
	
	// 각 통신망의 정보를 저장할 List 객체 networks 초기화
	static List<Network> networks;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Network 클래스 정의
	static class Network implements Comparable<Network> {
		
		// 해당 통신망이 연결하는 서버와 그 비용을 저장할 각 변수 초기화
		int startServer;
		int endServer;
		int cost;
		
		// 매개변수를 입력 받는 생성자 정의
		public Network(int startServer, int endServer, int cost) {
			this.startServer = startServer;
			this.endServer = endServer;
			this.cost = cost;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Network anotherNetwork) {
			
			// 통신망의 비용이 낮은 순서대로 정렬
			return this.cost - anotherNetwork.cost;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 행의 개수와 열의 개수를 각 변수에 할당
			int rowNum = Integer.parseInt(st.nextToken());
			int columnNum = Integer.parseInt(st.nextToken());
			
			// 각 서버가 통신할 수 있도록 하기 위한 최소 비용 및 설치한 통신망의 수를 저장할 각 변수 초기화
			int minCost = 0;
			int count = 0;
			
			// 각 서버의 대표 서버를 저장할 배열 rootServer 초기화
			rootServer = new int[rowNum * columnNum];
			
			// 각 통신망의 정보를 저장할 List 객체 networks 초기화
			networks = new ArrayList<>();
			
			// for 반복문을 사용해 각 서버의 대표 서버를 초기화
			for (int idx = 0; idx < rootServer.length; idx++)
				rootServer[idx] = idx;
			
			// for 반복문을 사용해 각 행을 순회
			for (int r = 0; r < rowNum; r++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 각 열을 연결하는 통신망을 순회
				for (int c = 0; c < columnNum - 1; c++) {
					
					// 현재 통신망이 연결하는 각 서버를 각 변수에 할당
					int startServer = r * columnNum + c;
					int endServer = startServer + 1;
					
					// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 해당 통신망의 비용을 변수 cost에 할당
					int cost = Integer.parseInt(st.nextToken());
					
					// add() 메서드를 사용해 해당 통신망을 networks에 저장
					networks.add(new Network(startServer, endServer, cost));
				}
			}
			
			// for 반복문을 사용해 각 행을 연결하는 통신망을 순회
			for (int r = 0; r < rowNum - 1; r++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 각 열을 순회
				for (int c = 0; c < columnNum; c++) {
					
					// 현재 통신망이 연결하는 각 서버를 각 변수에 할당
					int startServer = r * columnNum + c;
					int endServer = startServer + columnNum;
					
					// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 해당 통신망의 비용을 변수 cost에 할당
					int cost = Integer.parseInt(st.nextToken());
					
					// add() 메서드를 사용해 해당 통신망을 networks에 저장
					networks.add(new Network(startServer, endServer, cost));
				}
			}
			
			// sort() 메서드를 사용해 각 통신망을 비용이 낮은 순서대로 정렬
			Collections.sort(networks);
			
			// for 반복문을 사용해 각 통신망을 순회
			for (Network network : networks) {
				
				// 두 서버가 서로 연결되어 있는 경우 다음 통신망을 순회
				if (serverFinder(network.startServer) == serverFinder(network.endServer))
					continue;
				
				// serverConnector() 메서드를 호출해 두 서버를 연결 처리
				serverConnector(network.startServer, network.endServer);
				
				// 각 서버가 통신할 수 있도록 하기 위한 최소 비용 및 설치한 통신망의 수를 갱신
				minCost += network.cost;
				count++;
				
				// 서버를 모두 연결한 경우 반복문 탈출
				if (count == rowNum * columnNum - 1)
					break;
			}
			
			// write() 메서드를 사용해 각 서버가 통신할 수 있도록 하기 위한 최소 비용을 출력
			out.write(minCost + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// serverFinder() 메서드 정의
	public static int serverFinder(int server) {

		// 해당 서버의 대표 서버가 자기 자신인 경우 자기 자신을 반환
		if (rootServer[server] == server)
			return server;
		
		// serverFinder() 메서드를 재귀 호출해 대표 서버를 찾아 반환
		return rootServer[server] = serverFinder(rootServer[server]);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// serverConnector() 메서드 정의
	public static void serverConnector(int serverA, int serverB) {
		
		// serverFinder() 메서드를 호출해 두 서버의 대표 서버를 각 변수에 할당
		int rootServerA = serverFinder(serverA);
		int rootServerB = serverFinder(serverB);
		
		// max() 및 min() 메서드를 사용해 두 서버를 연결 처리
		rootServer[Math.max(rootServerA, rootServerB)] = Math.min(rootServerA, rootServerB);
	}
}