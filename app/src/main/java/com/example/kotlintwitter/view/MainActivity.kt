package com.example.kotlintwitter.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.kotlintwitter.*
import com.example.kotlintwitter.model.User
import com.example.kotlintwitter.util.RecyclerViewAdapter
import com.example.kotlintwitter.util.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import java.util.*

class MainActivity : AppCompatActivity(),
    RecyclerViewAdapter.ItemClickListener {
    var favouriteButton: ImageView? = null
    var image: ImageView? = null
    var viewPager: ViewPager? = null
    var tabLayout: TabLayout? = null
    var adapter: RecyclerViewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        favList = ArrayList<User>()
        list = ArrayList<User>()
        (list as ArrayList<User>).add(
            User(
                R.drawable.each_aesthetic_anime_icon_circle_png_peach_aesthetic_circle_11563141172sny88yk9kz,
                "Harvard Business",
                85,
                R.drawable.verify,
                "@HarvardBiz",
                "13:52",
                "Should companies make all of their employees' salaries transparent?",
                R.drawable.first,
                100,
                100,
                "21 Mar 20",
                "Twitter For iPhone",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.bag_present_512,
                "Bon Appétit",
                46,
                R.drawable.verify,
                "@bonappetit",
                "2h",
                "Don't be salty",
                R.drawable.second,
                48,
                31,
                "21  Mar 20",
                "Twitter For Android",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.profile,
                "John",
                25,
                R.drawable.verify,
                "@john",
                "6h",
                "Good luck tomorrow",
                R.drawable.third,
                48,
                31,
                "19 Mar 20",
                "Twitter For Android",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.beka,
                "Bekzat",
                12,
                0,
                "@bekzat",
                "1h",
                "Good luck tomorrow",
                R.drawable.fourth,
                48,
                31,
                "19 Mar 20",
                "Twitter For Advertisers",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.anika,
                "Anna",
                3,
                R.drawable.verify,
                "@anika95",
                "16 h",
                "Isolation activities #3 Internet yoga - keep moving if you can! There are a load of sites that are doing free trials right now. Check it. Plus no need to worry about being shit because no one can see Red heart @ Somewhere… https://instagram.com/p/B99CynrKKNC/?igshid=3y33gm9hm05f",
                R.drawable.virus
                ,
                40,
                36,
                "18 Mar 20",
                "Twitter For iPhone",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.narh,
                "Nargiz",
                5,
                0,
                "@narg",
                "1h",
                "Somethingajhnmas,",
                0,
                45,
                36,
                "17 Mar 20",
                "Twitter For iPhone",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.mipmap.circle3,
                "CNN Beaking News",
                12,
                R.drawable.verify,
                "@cnn",
                "5h",
                "President Trump said the US isn't considering a nationwide lockdown, but" +
                        " praised New York and California for issuing stay-at-home orders",
                R.drawable.president,
                48,
                31,
                "16 Mar 20",
                "Twitter For Advertisers",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.zha,
                "Zhamal",
                3,
                R.drawable.verify,
                "@zhamal45",
                "5m",
                "IM CRYING JOON WAS READY TO JUMP ON HIS ASS I CANTNTJTNDODND",
                0,
                120,
                156,
                "16 Mar 20",
                "Twitter For iPhone",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.mipmap.circle5,
                "Nargiz",
                5,
                R.drawable.verify,
                "@narg",
                "1h",
                "Somethingajhnmas,",
                0,
                45,
                36,
                "15 Mar 20",
                "Twitter For iPhone",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.abc_logo,
                "ABC News",
                17,
                R.drawable.verify,
                "@abc",
                "42m",
                "How religious leaders are adapting to keep the faith as coronavirus cancels mass gatherings.As people around the world adjust their daily routines in response to the coronavirus pandemic, the new limits on social gatherings have impacted a societal norm that might've once seemed unwavering and untouchable: religious services.\n" +
                        "\n" +
                        "Faith leaders across the United States are now tasked with keeping their congregations connected and involved amid what can feel like a trying test of faith.\n" +
                        "\n" +
                        "Archbishop Gregory Aymond of the Archdiocese of New Orleans, Rabbi Rachel Ain of Sutton Place Synagogue and Imam Dawud Walid, executive director for the Council on American-Islamic Relations (CAIR) in Michigan, joined ABC News' daily afternoon program, \"Pandemic: What You Need to Know,\" " +
                        "to discuss how they are moving their faith communities forward in the midst of the global crisis.",
                R.mipmap.abc1,
                20,
                45,
                "15 Mar 20",
                "SocialFlow",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.netflixlogo2,
                "Netflix US",
                442,
                R.drawable.verify,
                "@netflix",
                "2:08 AM",
                "Get your first look at Never Have I Ever, a coming-of-age comedy about the complicated life of a modern-day first-generation Indian American teenage girl, executive produced by Mindy Kaling and starring newcomer Maitreyi Ramakrishnan.\n" +
                        "\n" +
                        "@neverhaveiever\n" +
                        " premieres April 27",
                R.drawable.netflix,
                25,
                75,
                "21 Mar 20",
                "SocialFlow",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.bbc,
                "BBC news",
                32,
                R.drawable.verify,
                "@bbc",
                "54m",
                "Seventh Scottish coronavirus patient dies\nAnother patient has died in Scotland after testing positive for Covid-19, bringing the total number of deaths to seven, the Scottish government confirmed.\n" +
                        "\n" +
                        "The total number of Covid-19 cases is now 373, an increase of 51 on Friday.\n" +
                        "\n" +
                        "The figures also reveal 8,259 tests have been carried out across Scotland.\n" +
                        "\n" +
                        "NHS Greater Glasgow and Clyde now has 110 cases - up 19 - followed by NHS Lanarkshire with 49 and NHS Lothian with 44.\n" +
                        "\n" +
                        "Cases have been recorded in 12 of the 14 health board areas, with the exception of NHS Western Isles and NHS Orkney.\n" +
                        "\n",
                R.drawable.scotish,
                25,
                45,
                "21 Mar 20",
                "SocialFlow",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.parental,
                "Parental Advisory Podcast",
                32,
                0,
                "@PAPod",
                "10:27 PM",
                "Hey Y'all!\n" +
                        "I know we've been Ghost for a while here but the cast has been going up on podbean n spotify like normal. You'll see us here from time to time. Just wanted to let y'all know that WE STILL IN THIS… https://instagram.com/p/B0BkhH4n2CP/?igshid=p48uwyz3igpu",
                0,
                0,
                15,
                "21 Mar 20",
                "Instagram",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.british,
                "England",
                126,
                R.drawable.verify,
                "@England",
                "10:27 PM",
                "Hope. Expectation. Excitement. We couldn’t wait for the nation to unite in support of the #ThreeLions this summer.\n" +
                        "\n" +
                        "But now is the time to come together in a different way. Stay safe, stay home and take care of one another. \n" +
                        "@wembleystadium\n" +
                        " will roar again soon.",
                R.drawable.wembley,
                58,
                400,
                "17 Mar 20",
                "TweetDeck",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.linkedin,
                "LinkedIn",
                3,
                R.drawable.verify,
                "@LinkedIn",
                "2:46 AM",
                "People are pulling together, helping each other, and it's amazing. Keep connecting, keep sharing. We're all in this together.I've been blown away this week, seeing everyone pull together in this unprecedented and uncertain time. I'm seeing it in my neighborhood, in the local greater San Francisco area, in news stories around the world, and within our very own LinkedIn community. Scientists are offering to do free Q&As with kids stuck at home, CEOs are offering advice and guidance to struggling smaller businesses, and countless members are offering calming and inspirational words as we all collectively work from home, trying to figure out our new normal.\n" +
                        "\n" +
                        "And as the uncertainty of the coronavirus pandemic continues to challenge us, we need to come together. And we’re seeing this in the give and get help nature of the community on LinkedIn.\n" +
                        "\n" +
                        "Many people are sharing how they’re being impacted by the coronavirus—and how to help those being affected the most. The global editorial director at Nike encouraged marketers to creatively integrate musicians and artists into campaigns to help offset income losses due to shows and concerts getting canceled. Mark Cuban spent hours this weekend answering questions from small business owners who need help figuring out how to avoid layoffs and hourly reductions, spurring a conversation with more than 7,300 comments. \n" +
                        "\n" +
                        "Small business owners are sharing their concerns and fears but also their hopes. I was particularly inspired when I saw this post from a CEO: “As a small business owner, I’m definitely nervous about how this is going to affect us. It’s already affected us. But where there is concern, there is opportunity. Where there is fear, there is always bravery.”\n" +
                        "\n" +
                        "I’m writing this sitting at my kitchen table, which has been my new desk for the past couple weeks. It’s been years since I worked from home and it’s taking time to get used to it. Others are getting used to it too: last week we surveyed LinkedIn members and found that out of those growing number of people working from home nearly 30% plan to increase learning, if they’re able to find the time to do it. \n" +
                        "\n" +
                        "Working from home can feel isolating (which I guess is the point of social distancing, right?). However, we are not alone and can all take advantage of the tools to share thoughts, concerns, and solutions with a goal of helping others feeling the same things. For example, I’m seeing lots of posts on LinkedIn by working parents with kids at home now that many schools are closed. They’re sharing tips and tricks about how they’re managing. It’s spurring constructive conversations that end up helping more than just the original person who posted. \n" +
                        "\n" +
                        "LinkedIn Groups offer a way to connect with peers and feel supported, especially in the industries the most impacted. Retail workers are one of the groups struggling the most as many of them don’t have the option to work from home. This LinkedIn Group has been buzzing the past couple weeks - workers sharing their experiences with others who know exactly what they’re going through.\n" +
                        "\n" +
                        "From an editorial perspective, our team continues to curate the ever-changing news, making sure to highlight trusted sources and original perspectives in our new ‘Special Report: Coronavirus’ section on the homepage. In addition to collecting the most trusted content, we’re identifying where there are stories to be told and telling those too. \n" +
                        "\n" +
                        "One of the most recent episodes of our podcast Hello Monday, host Jessi Hempel spoke with Milan, Italy resident Kate Burson about the strange and surreal quiet of living under quarantine. It provides an interesting peek into how Italians are coping with their current situation.\n" +
                        "\n" +
                        "Support, advice, and insight from people you trust will always be invaluable because you took the time and effort to cultivate the right community for you. Your job and career may change directions or evolve while we’re in this time of uncertainty, but you and your network are on a professional journey together, and the stronger your network, the further everyone goes together.\n" +
                        "\n" +
                        "Thank you for being a part of the LinkedIn community. Keep engaging, keep sharing. This is the time communities need to virtually come together to be--and stay--connected.",
                R.drawable.`in`,
                3,
                98,
                "18 Mar 20",
                "Sprinklr Publishing",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.smth1,
                "MTV NEWS",
                32,
                R.drawable.verify,
                "@MTVNEWS",
                "2:24 AM",
                "As our testing abilities progress, the number of confirmed coronavirus cases will continue to rise. \n" +
                        "@Dometi_\n" +
                        " has what you #NeedToKnow about how you can be proactive and help others by slowing the spread of COVID-19 #AloneTogether",
                R.drawable.mtv,
                5,
                89,
                "18 Mar 20",
                "Twitter Media Studio",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.smth2,
                "alycia kamil",
                0,
                0,
                "@kamilalyciaa",
                "1:29 PM",
                "I keep seeing “it’s not about politics, it’s about human rights” with regards to corona responses.\n" +
                        "\n" +
                        "But getting to be *human* is political; providers making ethical decisions about who is worth saving is political; someone’s financial ability to social distance is political.",
                0,
                20,
                45,
                "20 Mar 20",
                "Twitter for iPhone",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.trump,
                "Donald J. Trump",
                900,
                R.drawable.verify,
                "@realDonaldTrump",
                "8:13 PM",
                "HYDROXYCHLOROQUINE & AZITHROMYCIN, taken together, have a real chance to be one of the biggest game changers in the history of medicine. The FDA has moved mountains - Thank You! Hopefully they will BOTH (H works better with A, International Journal of Antimicrobial Agents).....",
                0,
                75,
                952,
                "21 Mar 20",
                "Twitter for iPhone",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.p2,
                "National Geographic",
                25,
                R.drawable.verify,
                "@NatGeo",
                "9:00 PM",
                "An early ancestor to ducks and chickens waddled along the shores of modern-day Europe just before the asteroid impact that caused a global extinction event",
                0,
                10,
                35,
                "20 Mar 20",
                "Khoros",
                false
            )
        )
        (list as ArrayList<User>).add(
            User(
                R.drawable.p3,
                "Stanford Medicine",
                32,
                R.drawable.verify,
                "@StanfordMed",
                "11:33 PM",
                "Stanford Medicine leaders offered updates about local testing for COVID-19, as well as information about transmission and treatment of the respiratory disease, during a virtual town hall on March 12. \n" +
                        "\n" +
                        "In addition, they provided details about safety precautions and the ongoing response from Stanford Medicine, which comprises the School of Medicine, Stanford Health Care and Stanford Children’s Health. More than 7,000 people watched the event live online.The speakers on the town hall panel included the leadership of Stanford Medicine: Lloyd Minor, MD, dean of the School of Medicine; David Entwistle, Stanford Health Care president and CEO; and Paul King, Stanford Children’s Health president and CEO. Yvonne Maldonado, MD, a senior associate dean and professor of pediatric infectious diseases and of health research and policy, also joined the panel. The moderator was Andra Blomkalns, MD, professor and chair of the emergency medicine.\n" +
                        "\n" +
                        "“Let me express to you how proud we are of you and the great work that you do every day on behalf of our Stanford Medicine community, our community in our region, and the nation and the world,” Minor said.\n" +
                        "\n" +
                        "The panelists addressed questions from the Stanford Medicine community about COVID-19 and the virus that causes the disease. They described the health system’s approach to identifying patients with the illness and ensuring that exposure is minimal for other patients and employees.\n" +
                        "\n" +
                        "Diagnostic test, drive-through appointments\n" +
                        "Stanford Health Care has set up a drive-through testing service, by appointment, for people with symptoms who have been referred by a primary care provider, Entwistle said. \n" +
                        "\n" +
                        "The Food and Drug Administration-approved test was developed by a team led by Benjamin Pinsky, MD, PhD, associate professor of pathology and infectious diseases. It typically yields results within 24 hours. So far, it has been used to test hundreds of patients in the Bay Area, including at Stanford Health Care and other local health providers, Minor said. “We hope to double that in the not-too-distant future,” he added.\n" +
                        "\n" +
                        "At-risk patients who arrive at Stanford Hospital are greeted by health care providers outfitted in protective gear, including masks, gowns and gloves, Blomkalns said. She added that a triage area has been set up outside the Marc and Laura Andreessen Emergency Department to quickly identify patients who may have the virus and then provide care for them away from highly-trafficked spaces.\n" +
                        "\n" +
                        "Inside Stanford Hospital and Lucile Packard Children’s Hospital Stanford — both upgraded in the past two years — negative pressure rooms prevent the spread of airborne contaminants, Minor said. “We’re therefore prepared to protect our health care workforce from the spread of this virus,” he said.",
                R.drawable.stan,
                85,
                51,
                "16 Mar 20",
                "Khoros Marketing",
                false
            )
        )
        val rc = findViewById<RecyclerView>(R.id.list)
        val lc = LinearLayoutManager(this)
        rc.layoutManager = lc
        val dividerItemDecoration = DividerItemDecoration(
            rc.context,
            lc.orientation
        )
        rc.addItemDecoration(dividerItemDecoration)
        adapter = RecyclerViewAdapter(
            this,
            list as ArrayList<User>
        )
        rc.adapter = adapter
        favouriteButton = findViewById(R.id.sparkleButton)
        favouriteButton!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, FavouriteActivity::class.java)
            startActivity(intent)
        })
        viewPager = findViewById(R.id.viewpager)
        val viewPagerAdapter =
            ViewPagerAdapter(
                supportFragmentManager
            )
        viewPager!!.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                (viewPagerAdapter.instantiateItem(viewPager!!, position) as FragmentInterface).fragmentBecameVisible()
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        viewPager!!.adapter =
            ViewPagerAdapter(
                supportFragmentManager
            )
        tabLayout = findViewById(R.id.tabLayout)
        tabLayout!!.setTabTextColors(
            //предупреждение об устаревании метода
            resources.getColor(R.color.customTextColor),
            resources.getColor(R.color.customTextColor)
        )
        tabLayout!!.setTabTextColors(
            R.color.customTextColor,
            R.color.selectedColorText
        )
        tabLayout!!.setupWithViewPager(viewPager)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        adapter!!.notifyDataSetChanged()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onItemClick(view: View?, position: Int) {
        Log.e("YA", "ZDES'")
        /*Intent intent = new Intent(MainActivity.this,DetailActivity.class);
        startActivity(intent);*/
    }

    companion object {
        var list: MutableList<User>? = null
        var favList: MutableList<User>? = null
    }
}
