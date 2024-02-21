ALTER TABLE disease CONVERT TO CHARSET UTF8;
ALTER TABLE article CONVERT TO CHARSET UTF8;
ALTER TABLE comment CONVERT TO CHARSET UTF8;
ALTER TABLE user CONVERT TO CHARSET UTF8;

INSERT INTO disease (id, d_name, solution, src) VALUES ('1Tomato_Bacterial_spot', 'Tomato_Bacterial_spot', '종자를 50℃의 물에 25분간 침지하여 소독하고, 재배는 배수가 잘 되는 비옥한 토지를 선택하여 퇴비를 많이 넣어서 재배한다. 하우스에서는 저온기라도 다습하면 발생하게 되므로 환기와 통풍에 힘쓰고 급격한 온도변화가 없도록 한다. 약제방제는 농업용 항생제인 농용신수화제 1,200배액, 요네폰수화제 500배액, 가스란수화제 1,000배액을 발병초기에 2∼3회 살포하면 효과적이다.', '/image/1Tomato_Bacterial_spot.JPG');

INSERT INTO disease (id, d_name, solution, src) VALUES ('2Tomato_Early_blight', 'Tomato_Early_blight', '모판에서부터 발생되기 시작하므로 예방위주로 방제를 해야 한다. 또 이 병은 비료상태에 민감하므로 비배관리에 주의해야 한다. 방제약제로는 쿠퍼수화제 500배액, 놀란수화제 1,000배액 등이 있다.', '/image/2Tomato_Early_blight.JPG');

INSERT INTO disease (id, d_name, solution, src) VALUES ('3Tomato_Late_blight', 'Tomato_Late_blight', '모판에서부터 온도, 습도 관리에 주의하여 저온 다습이 되지 않도록 한다. 특히 11월 - 다음해 4월에 걸쳐 저온기의 재배는 저온다습에 주의한다. ', '/image/3Tomato_Late_blight.JPG');

INSERT INTO disease (id, d_name, solution, src) VALUES ('4Tomato_Leaf_Mold', 'Tomato_Leaf_Mold', '환기에 주의하여 습도를 낮추어주고 지면에는 비닐멀칭을 해서 지표면의 습기가 올라가지 않도록 한다. 점적관수를 이용해서 비닐 멀칭 밑으로 관수되게 하여 습기를 낯추는데 중점을 두어야 한다.', '/image/4Tomato_Leaf_Mold.JPG');

INSERT INTO disease (id, d_name, solution, src) VALUES ('5Tomato_Septoria_leaf_spot', 'Tomato_Septoria_leaf_spot', '종자를 선별하고, 소독하여 파종한다. 재배 시 균형시비를 한다.', '/image/5Tomato_Septoria_leaf_spot.JPG');

INSERT INTO disease (id, d_name, solution, src) VALUES ('6Tomato_Spider_Mites_Two', 'Tomato_Spider_Mites_Two',  '7월 상순경에 발생밀도를 관찰하여 엽당 2-3마리 이상이면 2차방제를 하여야 함. 이 시기에 가장 효과가 정확하고 좋은 약제를 선정해야 하며 이 때 제대로 방제가 안 되면 7월 하순-8월에 큰 피해를 입게 된다. 다음 방제적기는 8월 상-중순 고온기로서 엽당 3-4마리 이상이면 약제를 살포하여야 한다', '/image/6Tomato_Spider_Mites_Two.JPG');

INSERT INTO disease (id, d_name, solution, src) VALUES ('7Tomato_Target_Spot', 'Tomato_Target_Spot',  '클로로탈로닐, 만코제브, 옥시염화구리를 함유한 제품은 연구 실험에서 표적 지점을 잘 제어하는 ​​것으로 나타났습니다. 스트로빌루린 살진균제인 azoxystrobin 및 pyraclostrobin, 살진균제 boscalid 및 전신 획득 저항(SAR) 유발제인 acibenzolar-S-methyl도 표적 지점을 잘 제어하는 ​​것으로 나타났습니다. ', '/image/7Tomato_Target_Spot.JPG');

INSERT INTO disease (id, d_name, solution, src) VALUES ('8Tomato_YellowLeaf', 'Tomato_YellowLeaf', '하우스 내 및 주변의 철저한 관리가 필요하다. 토마토 재배 시설 주변에는 담배가루가 좋아하는 작물을 심지 말아야하며, 토마토 재배 시설 주변에 서식하는 토마토황화잎말림병의 중간 다리 역할을 하는 쑥 등 잡초들을 제거해야한다. 토마토 시설의 측창, 천창 및 출입문은 60메쉬 망을 설치하여 담배가루이 출입 및 외부로부터 유입을 차단해야한다.', '/image/8Tomato_YellowLeaf.JPG');

INSERT INTO disease (id, d_name, solution, src) VALUES ('9Tomato_Healthy', 'Tomato_Healthy', 'solution9', '/image/9Tomato_Healthy.JPG');

-- INSERT INTO `tomato`.`article` (`article_id`, `comment_time`, `update_time`, `article_writer`, `content`, `delete_yn`, `title`, `update_yn`) VALUES ('1', '23. 6. 9. 오후 4:50', '23. 6. 9. 오후 4:50', '작성자', '우스 내 및 주변의 철저한 관리가 필요하다. 토마토 재배 시설 주변에는 \n 담배가루가 좋아하는 작물을 심지 말아야하며,\n토마토 재배 시설 주변에 서식하는 토마토황화잎말림병의 중간 다리 역할을 \n하는 쑥 등 잡초들을 제거해야한다.\n 토마토 시설의 측창, 천창 및 출입문은 60메쉬 망을 설치하여 담배가루이 출입 및\n 외부로부터 유입을 차단해야한다\ndskfnsdklfnlsd\nsdfslkdf', 0, '제목', 0)

