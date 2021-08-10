package study.SWEA.month8_1.SWEA1861;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 문제이름 : 정사각형방
 * 링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc&categoryId=AV5LtJYKDzsDFAXc&categoryType=CODE&problemTitle=%EC%A0%95%EC%82%AC%EA%B0%81%ED%98%95&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
 */

public class SWEA1861 {
    static int[][] room;
    static int[][] visited;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};   //상하좌우
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        for (int t = 1; t <= tc; t++) {
            n = Integer.parseInt(br.readLine());
            room = new int[n][n];
            visited = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxR = 0;
            int maxC = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == 0) {
                        visited[i][j] = dfs(i, j, 1);
                        if (visited[i][j] == visited[maxR][maxC]) {    //현재 방의 카운트와 최대 카운트가 같으면
                            if (room[i][j] < room[maxR][maxC]) {    //방번호가 더 작으면
                                maxR = i;
                                maxC = j;
                            }    
                        } else if (visited[i][j] > visited[maxR][maxC]){    //현재 방의 카운트가 더 크면
                                maxR = i;
                                maxC = j;
                        }
                    }
                    
                }
            }
            bw.write("#"+t+" "+room[maxR][maxC]+" "+visited[maxR][maxC]+"\n");
        }
        bw.flush();
        bw.close();

    }

    public static int dfs(int r, int c, int cnt) {
        if (visited[r][c] != 0) {
            return visited[r][c] + cnt - 1;
        }

        for (int i = 0; i < dir.length; i++) {
            int R = r + dir[i][0];
            int C = c + dir[i][1];

            if (R < 0 || R >= n || C < 0 || C >= n || room[r][c] + 1 != room[R][C]) 
                continue;
            
            int result = dfs(R, C, cnt+1);
            visited[r][c] = result - cnt;
            return result;
        }   

        return cnt;
    }
}

/*
3
8
38 39 40 41 42 43 44 45 
46 47 48 49 50 51 52 53 
54 55 56 57 58 59 60 61 
62 63 64 1 2 3 4 5 
6 7 8 9 10 11 12 13 
14 15 16 17 18 19 20 21 
22 23 24 25 26 27 28 29 
30 31 32 33 34 35 36 37 
4
13 2 14 12 
10 16 6 5 
1 8 3 15 
7 11 4 9 
21
53 423 76 204 251 65 119 27 42 122 277 55 195 256 422 112 30 398 341 144 332 
381 32 19 264 56 286 300 401 213 342 238 135 68 91 161 345 280 416 102 75 392 
299 202 13 336 194 151 133 38 255 158 231 138 236 153 417 335 113 369 134 374 237 
263 80 44 294 377 99 21 1 273 162 327 233 436 252 291 404 104 430 421 433 437 
413 386 399 8 346 159 107 275 61 47 177 397 370 28 176 337 230 358 427 268 130 
424 141 4 408 292 174 200 250 221 324 79 160 311 308 334 396 143 126 90 179 258 
267 321 96 89 287 415 389 439 167 245 431 426 105 353 11 82 356 362 175 123 243 
239 425 40 106 152 16 328 7 272 2 246 136 365 137 241 281 298 70 379 34 293 
383 348 390 97 411 368 214 440 198 350 193 172 31 132 247 223 154 29 139 88 228 
288 432 351 95 312 414 15 261 227 12 265 319 285 186 269 52 58 5 352 235 309 
170 248 117 361 222 156 81 115 64 93 393 340 180 366 373 284 278 142 304 320 441 
23 318 171 376 354 212 17 60 290 148 110 419 74 403 147 405 124 310 114 391 39 
367 271 182 92 49 326 262 317 199 191 347 349 57 218 339 86 18 98 307 189 384 
303 313 125 87 201 51 24 163 270 325 224 207 25 6 282 120 77 279 338 190 306 
208 10 146 45 118 129 216 322 301 314 378 428 59 344 375 217 67 225 360 36 382 
197 364 412 145 438 372 406 363 380 78 429 181 165 400 296 128 330 435 140 100 407 
249 242 206 187 54 20 385 66 48 229 41 183 210 331 329 101 297 46 111 205 62 
420 359 395 253 295 69 155 103 72 333 84 244 215 388 121 323 150 305 73 357 394 
343 164 108 371 240 185 188 63 274 259 192 434 232 266 26 35 149 166 43 260 276 
168 33 289 226 85 410 315 196 409 22 302 203 116 50 71 316 219 211 402 37 83 
234 220 169 109 184 131 387 14 9 178 355 254 127 94 209 418 283 257 157 3 173 

1
3
1 2 3
6 5 4
9 8 7

1
4
13 2 14 12 
10 16 6 5 
1 8 3 15 
7 11 4 9 


탐색하면서 방문표시
방문한적 없으면
방문표시하고 카운트+1

방문한적있으면
현재 카운트 + 방문한 방에 저장된 카운트

*/