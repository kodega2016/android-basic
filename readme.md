#### Basic Android App Structure
Android application has mainly following folders.

### Folder Structure

#### java
- contains all the kotlin/java code that holds the logic of the application.

#### res
- contains all the design(xml) files and strings themes,values,colors.

#### java(generated)
- contains generated files

> The process of connecting view and the logic is known as layout inflation and starts when the activity starts.

Unlike other programming language,Android app doesnot have main method to start the application.It has
AndroidMainifest.xml file in which the entry point[Activity] file is declared.
```xml
 <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.Roll_dice"
        tools:targetApi="31">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
```

The activity class extends the AppCompatActivity class which has predefine method to start ,monitor the app state lifecyle.
```kotlin
class MainActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
```

#### Layout binding
We need to give a unique id to the view and find the view by id in the Activity as
```xml
<Button
    android:id="@+id/roll_button"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_gravity="center_horizontal"
    android:text="@string/roll"
/>

var button:Button=findViewById(R.id.roll_button);
button.text="I am from MainActivity";
```

#### Add Interacitivty
We need to get the view by id and setOnClick listener to the button
```kotlin
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    diceImage=findViewById(R.id.dice_image);

    var button:Button=findViewById(R.id.roll_button);

    button.setOnClickListener{
        rollDice();
    }
}

fun rollDice(){
    var dice:Int= Random.nextInt(6)+1;
    var drawableResource=when(dice){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else->R.drawable.dice_6
    }

    diceImage.setImageResource(drawableResource);

}
```