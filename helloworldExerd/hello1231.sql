-- 가이드
DROP TABLE IF EXISTS GUIDES RESTRICT;

-- 여행객
DROP TABLE IF EXISTS TOURISTS RESTRICT;

-- 공지사항
DROP TABLE IF EXISTS NOTICE RESTRICT;

-- Q&A
DROP TABLE IF EXISTS QNA RESTRICT;

-- 예약불가능일
DROP TABLE IF EXISTS DIS_BOOK RESTRICT;

-- 예약정보
DROP TABLE IF EXISTS BOOK_INFO RESTRICT;

-- 여행아이템
DROP TABLE IF EXISTS ITEMS RESTRICT;

-- 쪽지
DROP TABLE IF EXISTS MSG RESTRICT;

-- 상세사진
DROP TABLE IF EXISTS DET_PHOTS RESTRICT;

-- 여행일정
DROP TABLE IF EXISTS ITEM_SCH RESTRICT;

-- 리뷰
DROP TABLE IF EXISTS REVIEWS RESTRICT;

-- 한줄평
DROP TABLE IF EXISTS COMMENTS RESTRICT;

-- 리뷰사진
DROP TABLE IF EXISTS REV_PHOTS RESTRICT;

-- 가이드 사용가능언어
DROP TABLE IF EXISTS G_LANGS RESTRICT;

-- 태그
DROP TABLE IF EXISTS TAGS RESTRICT;

-- 사용자
DROP TABLE IF EXISTS USERS RESTRICT;

-- 가이드
CREATE TABLE GUIDES (
	G_EMAIL VARCHAR(40)   NOT NULL COMMENT '가이드이메일', -- 가이드이메일
	G_PHOT  VARCHAR(255)  NULL     COMMENT '가이드사진', -- 가이드사진
	G_COUNT INTEGER       NOT NULL COMMENT '가이드횟수', -- 가이드횟수
	G_CONT  VARCHAR(1000) NULL     COMMENT '가이드소개' -- 가이드소개
)
COMMENT '가이드';

-- 가이드
ALTER TABLE GUIDES
	ADD CONSTRAINT PK_GUIDES -- 가이드 기본키
		PRIMARY KEY (
			G_EMAIL -- 가이드이메일
		);

-- 여행객
CREATE TABLE TOURISTS (
	T_EMAIL  VARCHAR(40) NOT NULL COMMENT '여행객이메일', -- 여행객이메일
	T_GENDER INTEGER     NOT NULL COMMENT '성별' -- 성별
)
COMMENT '여행객';

-- 여행객
ALTER TABLE TOURISTS
	ADD CONSTRAINT PK_TOURISTS -- 여행객 기본키
		PRIMARY KEY (
			T_EMAIL -- 여행객이메일
		);

-- 공지사항
CREATE TABLE NOTICE (
	N_NO    INTEGER       NOT NULL COMMENT '공지번호', -- 공지번호
	N_DATE  DATE          NOT NULL COMMENT '작성날짜', -- 작성날짜
	N_TITLE VARCHAR(50)   NOT NULL COMMENT '제목', -- 제목
	N_CONT  VARCHAR(1000) NOT NULL COMMENT '내용' -- 내용
)
COMMENT '공지사항';

-- 공지사항
ALTER TABLE NOTICE
	ADD CONSTRAINT PK_NOTICE -- 공지사항 기본키
		PRIMARY KEY (
			N_NO -- 공지번호
		);

ALTER TABLE NOTICE
	MODIFY COLUMN N_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '공지번호';

-- Q&A
CREATE TABLE QNA (
	Q_NO    INTEGER       NOT NULL COMMENT '질문번호', -- 질문번호
	Q_TITLE VARCHAR(50)   NOT NULL COMMENT '질문제목', -- 질문제목
	Q_CONT  VARCHAR(1000) NOT NULL COMMENT '질문내용', -- 질문내용
	Q_DATE  DATE          NOT NULL COMMENT '질문날짜', -- 질문날짜
	A_CONT  VARCHAR(1000) NULL     COMMENT '답변내용', -- 답변내용
	A_DATE  DATE          NULL     COMMENT '답변날짜', -- 답변날짜
	EMAIL   VARCHAR(40)   NULL     COMMENT '이메일' -- 이메일
)
COMMENT 'Q&A';

-- Q&A
ALTER TABLE QNA
	ADD CONSTRAINT PK_QNA -- Q&A 기본키
		PRIMARY KEY (
			Q_NO -- 질문번호
		);

ALTER TABLE QNA
	MODIFY COLUMN Q_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '질문번호';

-- 예약불가능일
CREATE TABLE DIS_BOOK (
	GS_NO   INTEGER     NOT NULL COMMENT '가이드일정번호', -- 가이드일정번호
	GS_DATE DATE        NOT NULL COMMENT '날짜', -- 날짜
	G_EMAIL VARCHAR(40) NOT NULL COMMENT '가이드이메일' -- 가이드이메일
)
COMMENT '예약불가능일';

-- 예약불가능일
ALTER TABLE DIS_BOOK
	ADD CONSTRAINT PK_DIS_BOOK -- 예약불가능일 기본키
		PRIMARY KEY (
			GS_NO -- 가이드일정번호
		);

ALTER TABLE DIS_BOOK
	MODIFY COLUMN GS_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '가이드일정번호';

-- 예약정보
CREATE TABLE BOOK_INFO (
	C_NO    INTEGER      NOT NULL COMMENT '예약정보 번호', -- 예약정보 번호
	I_NO    INTEGER      NOT NULL COMMENT '상품번호', -- 상품번호
	C_SDATE DATE         NOT NULL COMMENT '가이드시작일', -- 가이드시작일
	C_EDATE DATE         NOT NULL COMMENT '가이드종료일', -- 가이드종료일
	C_STAT  VARCHAR(255) NOT NULL COMMENT '예약상태', -- 예약상태
	C_DATE  DATE         NOT NULL COMMENT '예약신청일', -- 예약신청일
	G_EMAIL VARCHAR(40)  NOT NULL COMMENT '가이드이메일', -- 가이드이메일
	T_EMAIL VARCHAR(40)  NOT NULL COMMENT '여행객이메일' -- 여행객이메일
)
COMMENT '예약정보';

-- 예약정보
ALTER TABLE BOOK_INFO
	ADD CONSTRAINT PK_BOOK_INFO -- 예약정보 기본키
		PRIMARY KEY (
			C_NO -- 예약정보 번호
		);

ALTER TABLE BOOK_INFO
	MODIFY COLUMN C_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '예약정보 번호';

-- 여행아이템
CREATE TABLE ITEMS (
	I_NO    INTEGER     NOT NULL COMMENT '상품번호', -- 상품번호
	COUNTRY VARCHAR(50) NOT NULL COMMENT '여행지', -- 여행지
	LANG    VARCHAR(50) NOT NULL COMMENT '언어', -- 언어
	TITLE   VARCHAR(50) NOT NULL COMMENT '제목', -- 제목
	PLACE   VARCHAR(50) NULL     COMMENT '주요장소', -- 주요장소
	G_EMAIL VARCHAR(40) NULL     COMMENT '가이드이메일' -- 가이드이메일
)
COMMENT '여행아이템';

-- 여행아이템
ALTER TABLE ITEMS
	ADD CONSTRAINT PK_ITEMS -- 여행아이템 기본키
		PRIMARY KEY (
			I_NO -- 상품번호
		);

ALTER TABLE ITEMS
	MODIFY COLUMN I_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '상품번호';

-- 쪽지
CREATE TABLE MSG (
	M_NO    INTEGER      NOT NULL COMMENT '쪽지번호', -- 쪽지번호
	M_DATE  DATE         NOT NULL COMMENT '보낸날짜', -- 보낸날짜
	M_CONT  VARCHAR(500) NULL     COMMENT '내용', -- 내용
	M_TITLE VARCHAR(50)  NOT NULL COMMENT '제목', -- 제목
	I_NO    INTEGER      NOT NULL COMMENT '상품번호', -- 상품번호
	G_EMAIL VARCHAR(40)  NULL     COMMENT '가이드이메일', -- 가이드이메일
	T_EMAIL VARCHAR(40)  NULL     COMMENT '여행객이메일' -- 여행객이메일
)
COMMENT '쪽지';

-- 쪽지
ALTER TABLE MSG
	ADD CONSTRAINT PK_MSG -- 쪽지 기본키
		PRIMARY KEY (
			M_NO -- 쪽지번호
		);

ALTER TABLE MSG
	MODIFY COLUMN M_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '쪽지번호';

-- 상세사진
CREATE TABLE DET_PHOTS (
	DET_PNO INTEGER      NOT NULL COMMENT '상세사진번호', -- 상세사진번호
	I_NO    INTEGER      NOT NULL COMMENT '상품번호', -- 상품번호
	P_URL   VARCHAR(255) NOT NULL COMMENT '사진경로' -- 사진경로
)
COMMENT '상세사진';

-- 상세사진
ALTER TABLE DET_PHOTS
	ADD CONSTRAINT PK_DET_PHOTS -- 상세사진 기본키
		PRIMARY KEY (
			DET_PNO -- 상세사진번호
		);

ALTER TABLE DET_PHOTS
	MODIFY COLUMN DET_PNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '상세사진번호';

-- 여행일정
CREATE TABLE ITEM_SCH (
	T_NO   INTEGER       NOT NULL COMMENT '여행일정번호', -- 여행일정번호
	I_NO   INTEGER       NOT NULL COMMENT '상품번호', -- 상품번호
	T_DAY  INTEGER       NOT NULL COMMENT '여행일차', -- 여행일차
	T_TIME TIME          NOT NULL COMMENT '여행시간', -- 여행시간
	T_CONT VARCHAR(1000) NOT NULL COMMENT '여행내용' -- 여행내용
)
COMMENT '여행일정';

-- 여행일정
ALTER TABLE ITEM_SCH
	ADD CONSTRAINT PK_ITEM_SCH -- 여행일정 기본키
		PRIMARY KEY (
			T_NO -- 여행일정번호
		);

ALTER TABLE ITEM_SCH
	MODIFY COLUMN T_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '여행일정번호';

-- 리뷰
CREATE TABLE REVIEWS (
	C_NO    INTEGER       NOT NULL COMMENT '예약정보 번호', -- 예약정보 번호
	R_TITLE VARCHAR(50)   NOT NULL COMMENT '제목', -- 제목
	R_CONT  VARCHAR(1000) NOT NULL COMMENT '내용', -- 내용
	R_DATE  DATE          NOT NULL COMMENT '리뷰날짜' -- 리뷰날짜
)
COMMENT '리뷰';

-- 리뷰
ALTER TABLE REVIEWS
	ADD CONSTRAINT PK_REVIEWS -- 리뷰 기본키
		PRIMARY KEY (
			C_NO -- 예약정보 번호
		);

-- 한줄평
CREATE TABLE COMMENTS (
	C_NO     INTEGER      NOT NULL COMMENT '예약정보 번호', -- 예약정보 번호
	COM_CONT VARCHAR(500) NOT NULL COMMENT '내용', -- 내용
	COM_DATE DATE         NOT NULL COMMENT '한줄평날짜', -- 한줄평날짜
	COM_SCO  INTEGER      NOT NULL COMMENT '별점' -- 별점
)
COMMENT '한줄평';

-- 한줄평
ALTER TABLE COMMENTS
	ADD CONSTRAINT PK_COMMENTS -- 한줄평 기본키
		PRIMARY KEY (
			C_NO -- 예약정보 번호
		);

-- 리뷰사진
CREATE TABLE REV_PHOTS (
	R_PNO  INTEGER      NOT NULL COMMENT '사진번호', -- 사진번호
	RP_URL VARCHAR(255) NOT NULL COMMENT '사진경로', -- 사진경로
	C_NO   INTEGER      NOT NULL COMMENT '예약정보 번호' -- 예약정보 번호
)
COMMENT '리뷰사진';

-- 리뷰사진
ALTER TABLE REV_PHOTS
	ADD CONSTRAINT PK_REV_PHOTS -- 리뷰사진 기본키
		PRIMARY KEY (
			R_PNO -- 사진번호
		);

ALTER TABLE REV_PHOTS
	MODIFY COLUMN R_PNO INTEGER NOT NULL AUTO_INCREMENT COMMENT '사진번호';

-- 가이드 사용가능언어
CREATE TABLE G_LANGS (
	AL_NO   INTEGER     NOT NULL COMMENT '가능언어번호', -- 가능언어번호
	ALANG   VARCHAR(50) NOT NULL COMMENT '사용가능언어', -- 사용가능언어
	G_EMAIL VARCHAR(40) NOT NULL COMMENT '가이드이메일' -- 가이드이메일
)
COMMENT '가이드 사용가능언어';

-- 가이드 사용가능언어
ALTER TABLE G_LANGS
	ADD CONSTRAINT PK_G_LANGS -- 가이드 사용가능언어 기본키
		PRIMARY KEY (
			AL_NO -- 가능언어번호
		);

ALTER TABLE G_LANGS
	MODIFY COLUMN AL_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '가능언어번호';

-- 태그
CREATE TABLE TAGS (
	T_NO  INTEGER     NOT NULL COMMENT '태그일련번호', -- 태그일련번호
	I_NO  INTEGER     NULL     COMMENT '상품번호', -- 상품번호
	INTER VARCHAR(50) NOT NULL COMMENT '관심사' -- 관심사
)
COMMENT '태그';

-- 태그
ALTER TABLE TAGS
	ADD CONSTRAINT PK_TAGS -- 태그 기본키
		PRIMARY KEY (
			T_NO -- 태그일련번호
		);

ALTER TABLE TAGS
	MODIFY COLUMN T_NO INTEGER NOT NULL AUTO_INCREMENT COMMENT '태그일련번호';

-- 사용자
CREATE TABLE USERS (
	EMAIL VARCHAR(40) NOT NULL COMMENT '이메일', -- 이메일
	UNAME VARCHAR(50) NOT NULL COMMENT '이름', -- 이름
	TEL   VARCHAR(30) NOT NULL COMMENT '전화', -- 전화
	PWD   VARCHAR(30) NOT NULL COMMENT '암호', -- 암호
	BIRTH DATE        NOT NULL COMMENT '생년월일' -- 생년월일
)
COMMENT '사용자';

-- 사용자
ALTER TABLE USERS
	ADD CONSTRAINT PK_USERS -- 사용자 기본키
		PRIMARY KEY (
			EMAIL -- 이메일
		);

-- 가이드
ALTER TABLE GUIDES
	ADD CONSTRAINT FK_USERS_TO_GUIDES -- 사용자 -> 가이드
		FOREIGN KEY (
			G_EMAIL -- 가이드이메일
		)
		REFERENCES USERS ( -- 사용자
			EMAIL -- 이메일
		);

-- 여행객
ALTER TABLE TOURISTS
	ADD CONSTRAINT FK_USERS_TO_TOURISTS -- 사용자 -> 여행객
		FOREIGN KEY (
			T_EMAIL -- 여행객이메일
		)
		REFERENCES USERS ( -- 사용자
			EMAIL -- 이메일
		);

-- Q&A
ALTER TABLE QNA
	ADD CONSTRAINT FK_USERS_TO_QNA -- 사용자 -> Q&A
		FOREIGN KEY (
			EMAIL -- 이메일
		)
		REFERENCES USERS ( -- 사용자
			EMAIL -- 이메일
		);

-- 예약불가능일
ALTER TABLE DIS_BOOK
	ADD CONSTRAINT FK_GUIDES_TO_DIS_BOOK -- 가이드 -> 예약불가능일
		FOREIGN KEY (
			G_EMAIL -- 가이드이메일
		)
		REFERENCES GUIDES ( -- 가이드
			G_EMAIL -- 가이드이메일
		);

-- 예약정보
ALTER TABLE BOOK_INFO
	ADD CONSTRAINT FK_ITEMS_TO_BOOK_INFO -- 여행아이템 -> 예약정보
		FOREIGN KEY (
			I_NO -- 상품번호
		)
		REFERENCES ITEMS ( -- 여행아이템
			I_NO -- 상품번호
		);

-- 예약정보
ALTER TABLE BOOK_INFO
	ADD CONSTRAINT FK_GUIDES_TO_BOOK_INFO -- 가이드 -> 예약정보
		FOREIGN KEY (
			G_EMAIL -- 가이드이메일
		)
		REFERENCES GUIDES ( -- 가이드
			G_EMAIL -- 가이드이메일
		);

-- 예약정보
ALTER TABLE BOOK_INFO
	ADD CONSTRAINT FK_TOURISTS_TO_BOOK_INFO -- 여행객 -> 예약정보
		FOREIGN KEY (
			T_EMAIL -- 여행객이메일
		)
		REFERENCES TOURISTS ( -- 여행객
			T_EMAIL -- 여행객이메일
		);

-- 여행아이템
ALTER TABLE ITEMS
	ADD CONSTRAINT FK_GUIDES_TO_ITEMS -- 가이드 -> 여행아이템
		FOREIGN KEY (
			G_EMAIL -- 가이드이메일
		)
		REFERENCES GUIDES ( -- 가이드
			G_EMAIL -- 가이드이메일
		);

-- 쪽지
ALTER TABLE MSG
	ADD CONSTRAINT FK_ITEMS_TO_MSG -- 여행아이템 -> 쪽지
		FOREIGN KEY (
			I_NO -- 상품번호
		)
		REFERENCES ITEMS ( -- 여행아이템
			I_NO -- 상품번호
		);

-- 쪽지
ALTER TABLE MSG
	ADD CONSTRAINT FK_GUIDES_TO_MSG -- 가이드 -> 쪽지
		FOREIGN KEY (
			G_EMAIL -- 가이드이메일
		)
		REFERENCES GUIDES ( -- 가이드
			G_EMAIL -- 가이드이메일
		);

-- 쪽지
ALTER TABLE MSG
	ADD CONSTRAINT FK_TOURISTS_TO_MSG -- 여행객 -> 쪽지
		FOREIGN KEY (
			T_EMAIL -- 여행객이메일
		)
		REFERENCES TOURISTS ( -- 여행객
			T_EMAIL -- 여행객이메일
		);

-- 상세사진
ALTER TABLE DET_PHOTS
	ADD CONSTRAINT FK_ITEMS_TO_DET_PHOTS -- 여행아이템 -> 상세사진
		FOREIGN KEY (
			I_NO -- 상품번호
		)
		REFERENCES ITEMS ( -- 여행아이템
			I_NO -- 상품번호
		);

-- 여행일정
ALTER TABLE ITEM_SCH
	ADD CONSTRAINT FK_ITEMS_TO_ITEM_SCH -- 여행아이템 -> 여행일정
		FOREIGN KEY (
			I_NO -- 상품번호
		)
		REFERENCES ITEMS ( -- 여행아이템
			I_NO -- 상품번호
		);

-- 리뷰
ALTER TABLE REVIEWS
	ADD CONSTRAINT FK_BOOK_INFO_TO_REVIEWS -- 예약정보 -> 리뷰
		FOREIGN KEY (
			C_NO -- 예약정보 번호
		)
		REFERENCES BOOK_INFO ( -- 예약정보
			C_NO -- 예약정보 번호
		);

-- 한줄평
ALTER TABLE COMMENTS
	ADD CONSTRAINT FK_BOOK_INFO_TO_COMMENTS -- 예약정보 -> 한줄평
		FOREIGN KEY (
			C_NO -- 예약정보 번호
		)
		REFERENCES BOOK_INFO ( -- 예약정보
			C_NO -- 예약정보 번호
		);

-- 리뷰사진
ALTER TABLE REV_PHOTS
	ADD CONSTRAINT FK_REVIEWS_TO_REV_PHOTS -- 리뷰 -> 리뷰사진
		FOREIGN KEY (
			C_NO -- 예약정보 번호
		)
		REFERENCES REVIEWS ( -- 리뷰
			C_NO -- 예약정보 번호
		);

-- 가이드 사용가능언어
ALTER TABLE G_LANGS
	ADD CONSTRAINT FK_GUIDES_TO_G_LANGS -- 가이드 -> 가이드 사용가능언어
		FOREIGN KEY (
			G_EMAIL -- 가이드이메일
		)
		REFERENCES GUIDES ( -- 가이드
			G_EMAIL -- 가이드이메일
		);

-- 태그
ALTER TABLE TAGS
	ADD CONSTRAINT FK_ITEMS_TO_TAGS -- 여행아이템 -> 태그
		FOREIGN KEY (
			I_NO -- 상품번호
		)
		REFERENCES ITEMS ( -- 여행아이템
			I_NO -- 상품번호
		);