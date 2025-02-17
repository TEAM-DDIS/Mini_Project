package teamDA.catcafe.repository;

import teamDA.catcafe.aggregate.Cat;
import teamDA.catcafe.aggregate.CatStatus;
import teamDA.catcafe.aggregate.Gender;
import teamDA.catcafe.stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;

public class CatRepository {


    private final ArrayList<Cat> catList = new ArrayList<>();
    private final File file =
            new File("src/main/java/teamDA/catcafe/db/catDB.dat");

    public CatRepository() {

        if (!file.exists()) {
            ArrayList<Cat> defaultCats = new ArrayList<>();
            defaultCats.add(new Cat(1, "나비", "코리안숏헤어", Gender.FEMALE, "2024-02-12", CatStatus.ACTIVE, false));
            defaultCats.add(new Cat(2, "강하돌", "브리티쉬숏헤어", Gender.MALE, "2022-05-07", CatStatus.ACTIVE, true));
            defaultCats.add(new Cat(3, "강하루", "하이랜드폴드", Gender.MALE, "2021-01-05", CatStatus.ACTIVE, true));

            saveCats(defaultCats);  // 더미데이터 저장 메소드
        }

        loadCats();
    }

    private void loadCats() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(file)
                )
        )) {
            while (true) {
                catList.add((Cat)ois.readObject());
            }

        } catch (EOFException e){
            System.out.println("고양이 정보 다 읽어옴");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveCats(ArrayList<Cat> inputCats) {
        ObjectOutputStream oos = null;  // 객체를 직렬화하기 위해 ObjectOutputStream 사용

        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)
                    )
            );

            for (Cat cat : inputCats) {
                oos.writeObject(cat);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Cat> selectAllCats() { return catList; }

    public Cat selectCatBy(int catNo) {
        Cat returnCat = null;

        for (Cat cat : catList) {
            if (cat.getCatNo() == catNo) {
                returnCat = cat;
            }
        }

        return returnCat;
    }

    public int selectCatNo() {
        Cat lastCat = catList.get(catList.size() - 1);
        return lastCat.getCatNo();
    }

    // 첫 헤더 제외하고 디비에 저장하도록
    public int insertCat(Cat cat) {
        MyObjectOutput moo = null;

        int result = 0;

        try {
            moo = new MyObjectOutput
                   (new BufferedOutputStream
                           (new FileOutputStream(file, true))
                   );

            //파일로 신규 회원 추가
            moo.writeObject(cat);

            // 신규 회원 추가 컬렉션에 저장
            catList.add(cat);

            result = 1;

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
              if(moo != null) moo.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    // 수정된 사본이 넘어옴
    public int updateCat(Cat reformedCat) {
        for (int i = 0; i < catList.size(); i++) {
            if (catList.get(i).getCatNo() == reformedCat.getCatNo()) {
                catList.set(i, reformedCat);   // 컬렉션 update
                saveCats(catList);             // 파일 update
                return 1;
            }
        }
        return 0;
    }

    // softdelete
    public int deleteCat(int removeCatNo) {
        int result = 0;
        for (Cat cat : catList) {
            if (cat.getCatNo() == removeCatNo) {
                cat.setCatStatus(CatStatus.DEACTIVATED);
                result = 1;
                saveCats(catList);
            }
        }
        return result;
    }
}
