# LakuePopupActivity
 * LakuePopupActivity is popsup and is easy to call back.
 * Used in various places such as error, image, notice.  
 
[![](https://jitpack.io/v/lakue119/LakuePopupActivity.svg)](https://jitpack.io/#lakue119/LakuePopupActivity)
# Sample
<div>
<img width="40%" src="https://user-images.githubusercontent.com/31702431/76101430-c68c1080-6011-11ea-940b-4a82d66311cf.jpeg">
</div>
<div>
<img width="40%" src="https://user-images.githubusercontent.com/31702431/76101710-36020000-6012-11ea-89da-268a0d494da9.jpeg">
<img width="40%" src="https://user-images.githubusercontent.com/31702431/76101436-c7bd3d80-6011-11ea-9e1e-e375e9dd14ac.jpeg">
</div>
<div>
<img width="40%" src="https://user-images.githubusercontent.com/31702431/76101441-c8ee6a80-6011-11ea-866e-5daf69d9e408.jpeg">
<img width="40%" src="https://user-images.githubusercontent.com/31702431/76101444-c9870100-6011-11ea-95eb-ef959a95cfbf.jpeg">
</div>

# Install
Add Jitpack to your repositories in your build.gradle file
<pre>
<code>
  allprojects {
      repositories {
        // ...
        maven { url 'https://jitpack.io' }
      }
  }
</code>
</pre>

Add the below to your dependencies, again in your gradle.build file

<pre>
<code>

dependencies {
    //Add LakuePopupActivity Library
   implementation 'com.github.lakue119:LakuePopupActivity:1.0.1'
}
</code>
</pre>

# Code
How to use  
  
  
First Popup

``` 
     btn_show_popup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PopupActivity.class);
                intent.putExtra("type", PopupType.NORMAL);
                intent.putExtra("gravity", PopupGravity.CENTER);
                intent.putExtra("title", "공지사항");
                intent.putExtra("content", "Popup Activity was made by Lakue");
                intent.putExtra("buttonCenter", "종료");
                startActivityForResult(intent, 1);
            }
        });
```  

|Key|Type|Content|
|------|---|---|
|type|PopupType|PopupActivity Type|
|gravity|PopupGravity|Align text inside an activity|
|title|String|Activity Title|
|content|String|Activity Contents|
|buttonCenter|String|Button Text|

Second Popup

``` 
        btn_show_popup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PopupActivity.class);
                intent.putExtra("type", PopupType.SELECT);
                intent.putExtra("gravity", PopupGravity.LEFT);
                intent.putExtra("title", "공지사항");
                intent.putExtra("content", "Did Lakue make a Popup Activity?");
                intent.putExtra("buttonLeft", "예");
                intent.putExtra("buttonRight", "아니오");
                startActivityForResult(intent, 2);
            }
        });
```  

|Key|Type|Content|
|------|---|---|
|type|PopupType|PopupActivity Type|
|gravity|PopupGravity|Align text inside an activity|
|title|String|Activity Title|
|content|String|Activity Contents|
|buttonLeft|String|Left Button Text|
|buttonRight|String|Right Button Text|  

Third Popup

``` 
        btn_show_popup3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PopupActivity.class);
                intent.putExtra("type", PopupType.ERROR);
                intent.putExtra("gravity", PopupGravity.RIGHT);
                intent.putExtra("title", "ERROR");
                intent.putExtra("content", "ERROR Message");
                intent.putExtra("buttonRight", "닫기");
                startActivityForResult(intent, 3);
            }
        });
```  

|Key|Type|Content|
|------|---|---|
|type|PopupType|PopupActivity Type|
|gravity|PopupGravity|Align text inside an activity|
|title|String|Activity Title|
|content|String|Activity Contents|
|buttonRight|String|Right Button Text|    

Four Popup

``` 
        btn_show_popup4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), PopupActivity.class);
                intent.putExtra("type", PopupType.IMAGE);
                intent.putExtra("title", "ImageUrl"); //Image
                intent.putExtra("buttonLeft", "종료");
                intent.putExtra("buttonRight", "바로가기");
                startActivityForResult(intent, 4);
            }
        });
```  
|Key|Type|Content|
|------|---|---|
|type|PopupType|PopupActivity Type|
|title|String|Activity ImageUrl|
|buttonLeft|String|Left Button Text|
|buttonRight|String|Right Button Text|   


# CallBack
``` 
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            //데이터 받기
            if(requestCode == 1){
                PopupResult result = (PopupResult) data.getSerializableExtra("result");
                if(result == PopupResult.CENTER){
                    // 작성 코드
                    Toast.makeText(this, "CENTER", Toast.LENGTH_SHORT).show();
                }
            }
            if(requestCode == 2){
                PopupResult result = (PopupResult) data.getSerializableExtra("result");
                if(result == PopupResult.LEFT){
                    // 작성 코드
                    Toast.makeText(this, "LEFT", Toast.LENGTH_SHORT).show();

                } else if(result == PopupResult.RIGHT){
                    // 작성 코드
                    Toast.makeText(this, "RIGHT", Toast.LENGTH_SHORT).show();

                }
            }
            if(requestCode == 3){
                PopupResult result = (PopupResult) data.getSerializableExtra("result");
                if(result == PopupResult.CENTER){
                    // 작성 코드
                    Toast.makeText(this, "CENTER", Toast.LENGTH_SHORT).show();

                }
            }
            if(requestCode == 4){
                PopupResult result = (PopupResult) data.getSerializableExtra("result");
                if(result == PopupResult.LEFT){
                    // 작성 코드
                    Toast.makeText(this, "LEFT", Toast.LENGTH_SHORT).show();

                } else if(result == PopupResult.RIGHT){
                    // 작성 코드
                    Toast.makeText(this, "RIGHT", Toast.LENGTH_SHORT).show();

                } else if(result == PopupResult.IMAGE){
                    // 작성 코드
                    Toast.makeText(this, "IMAGE", Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
``` 
