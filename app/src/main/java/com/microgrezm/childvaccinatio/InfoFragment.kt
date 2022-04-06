package com.microgrezm.childvaccinatio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.microgrezm.childvaccination.adapter.InfoAdapter
import com.microgrezm.childvaccination.data.InfoData
import java.util.ArrayList

class InfoFragment :Fragment() {
    var rv: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v = inflater.inflate(R.layout.fragment_info, container, false)
        rv = v.findViewById(R.id.rv_info)
        var myArr = ArrayList<InfoData>()
        var myAdapter = InfoAdapter(context)
        myAdapter.setList(myArr)
        var myLayoutManager1 = GridLayoutManager(context, 1)
        myArr.add(
            InfoData(
                "BACILLUS CALMETTE GUERIN (BCG) VACCINE ",
                "BCG vaccine is derived from the bovine tuberculosis strain and was first developed in 1921. The vaccine contains 0.1–0.4 million live viable bacilli per dose \n" +
                        "\n" +
                        "Recommended Schedule \n" +
                        "\n" +
                        "At Birth or as early as possible within the first 3 days "
            )
        )
        myArr.add(
            InfoData(
                "HEPATITIS B VACCINE (Hep B) ",
                "Hepatitis B Virus (HBV) is the major cause of chronic liver disease and hepato-cellular carcinoma and Hepatitis B vaccine may also be given in any of the following schedules \n" +
                        "\n" +
                        "6 and 14 weeks \n" +
                        "\n" +
                        "6, 10 and 14 weeks \n" +
                        "\n" +
                        "Birth, 6 weeks, 6 months \n" +
                        "\n" +
                        "Birth, 6 weeks, 10 weeks, and 14 weeks \n" +
                        "\n" +
                        "None of the above schedules needs boosters But More generally (ii) schedule is followed. \n" +
                        "\n" +
                        "Recommended Schedule \n" +
                        "\n" +
                        "Three primary doses at 6, 10 and 14 Weeks \n" +
                        "\n" +
                        " "
            )
        )
        myArr.add(
            InfoData(
                "INACTIVATED POLIO VACCINE (IPV) ",
                "IPV is formaldehyde killed poliovirus, grown in monkey kidney cell/human diploid cells. \n" +
                        "\n" +
                        "Minimum age: 6 weeks. \n" +
                        "\n" +
                        "Recommended Schedule \n" +
                        "\n" +
                        "Three primary doses at 6, 10 and 14 Weeks and one booster at 15 to 18 months \n" +
                        "\n" +
                        "Note: \n" +
                        "\n" +
                        "All doses of IPV may be replaced with OPV if administration of the IPV is unfeasible. No of doses for primary series can be 2 instead of 3 if primary series started at 8 weeks and the interval between the doses is kept 8 weeks. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        " "
            )
        )
        myArr.add(
            InfoData(
                " \n" +
                        "\n" +
                        "DIPHTHERIA, TETANUS AND PERTUSSIS VACCINES (DTP) ", " \n" +
                        "\n" +
                        "There are two types of DTP vaccines are available. These are \n" +
                        "\n" +
                        "DTwP Vaccines \n" +
                        "\n" +
                        "Popularly known as triple antigen, DTwP is composed of tetanus and diphtheria toxoids as well as killed whole cell pertussis bacilli adsorbed on insoluble aluminium salts which act as adjuvants. \n" +
                        "\n" +
                        "DTaP Vaccines \n" +
                        "\n" +
                        "All aP vaccines are associated with significantly lesser side-effects, and thus the replacement of the wP vaccines was mainly driven by the safety-profile of these vaccines \n" +
                        "\n" +
                        "Note: \n" +
                        "\n" +
                        "DTaP may be preferred to DTwP in children with history of severe adverse effects after previous dose/s of DTwP or children with neurologic disorders. \n" +
                        "\n" +
                        "Minimum Age: 6 weeks \n" +
                        "\n" +
                        "Recommended Schedule \n" +
                        "\n" +
                        "Three primary doses at 6, 10 and 14 Weeks and two boosters at 15 to 18 months and 5 years \n" +
                        "\n" +
                        "Note: \n" +
                        "\n" +
                        "The first booster (4th dose) may be administered as early as age 12 months, provided at least 6 months have elapsed since the third dose. \n" +
                        "\n" +
                        " "
            )
        )
        myArr.add(
            InfoData(
                " \n" +
                        "\n" +
                        "HAEMOPHILUS INFLUENZAE TYPE B (Hib) CONJUGATE VACCINES ", " \n" +
                        "\n" +
                        "Haemophilus Influenzae Type B (Hib) is an important invasive pathogen causing diseases such as meningitis, bacteremia, pneumonia, cellulitis, osteomyelitis, septic arthritis and epiglottitis \n" +
                        "\n" +
                        "Minimum age: 6 weeks \n" +
                        "\n" +
                        "Recommended Schedule \n" +
                        "\n" +
                        "Primary series includes Hib conjugate vaccine at ages 6, 10, 14 weeks with a booster at age 12 through 18 months \n" +
                        "\n" +
                        " "
            )
        )
        myArr.add(
            InfoData(
                " \n" +
                        "\n" +
                        "PNEUMOCOCCALVACCINES (PCV) ", " \n" +
                        "\n" +
                        "Pneumococcal infections include serious diseases such as meningitis, bacteremia, and pneumonia, as well as milder but more common illnesses, such as sinusitis and otitis media. Currently two types of vaccines are licensed for use; \n" +
                        "\n" +
                        "(1) Pneumococcal Polysaccharide Vaccine (PPSV) \n" +
                        "\n" +
                        "(2) Pneumococcal Conjugate Vaccines (PCVs). \n" +
                        "\n" +
                        "Minimum age: 6 weeks \n" +
                        "\n" +
                        "Recommended Schedule \n" +
                        "\n" +
                        "Three primary doses with an interval of at least 4 weeks between doses, plus a booster at least 6 months after the third dose (3p+1 schedule) and The first dose can be given as early as 6 weeks of age; the booster dose is given preferably between 12 and 15 months of age. \n" +
                        "\n" +
                        "Note: \n" +
                        "\n" +
                        "Previously unvaccinated infants aged 7 to 11 months should receive 2 doses, the second dose at least 4 weeks after the first, followed by a third dose in the second year of life Minimum interval between two doses is 4 weeks for children vaccinated at age <12 months \n" +
                        "\n" +
                        " "
            )
        )
        myArr.add(
            InfoData(
                "ROTAVIRUS VACCINES ",
                "Rotaviruses are globally the leading cause of severe, dehydrating Diarrhea in children aged <5 years. In low-income countries 80% of primary rotavirus infection occur among infants <1 year old, whereas in high-income countries, the first episode may occasionally be delayed until the age of 2–5 years. Currently two live oral vaccines are licensed and marketed worldwide:- \n" +
                        "\n" +
                        "Human Monovalent live vaccine (RV1) \n" +
                        "\n" +
                        "Human bovine Pentavalent live vaccine (RV5) \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Minimum age: 6 weeks for both RV-1 [Rotarix] and RV-5 [RotaTeq]) \n" +
                        "\n" +
                        "Recommended Schedule \n" +
                        "\n" +
                        "RV1 should preferably be employed (Only two doses) in 10 and 14 week-schedule, instead of 6 and 10 weeks; the former schedule is found to be far more immunogenic than the later. \n" +
                        "\n" +
                        "RV5 should be employed in a three-dose 6, 10, and 14 week schedule. If any dose in series was RV5 or vaccine product is unknown for any dose in the series, a total of 3 doses of RV vaccine should be administered. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        " "
            )
        )
        myArr.add(
            InfoData(
                "TYPHOID VACCINES ",
                "Typhoid fever is a disease of developing countries associated with poor public health and low socio-economic indices. The new generation current typhoid fever vaccines include \n" +
                        "\n" +
                        "Oral live Attenuated Ty21a Vaccine: Oral Live Attenuated Ty21a vaccine is not available in the country \n" +
                        "\n" +
                        "Vi-capsular polysaccharide (Vi-PS) vaccine: The vaccine contains highly purified antigenic fraction of Vi-capsular polysaccharide antigen of S. typhi, which is a virulence factor of the bacteria. \n" +
                        "\n" +
                        "Vi-capsular polysaccharides (Vi-PS) conjugate Vaccines: Vi-PS conjugate typhoid vaccine by using exotoxin A of Pseudomonas aeruginosa as a carrier protein. \n" +
                        "\n" +
                        "Both Vi-PS (polysaccharide) and Vi-PS conjugate vaccines are available. \n" +
                        "\n" +
                        "Note: \n" +
                        "\n" +
                        "Vi-PS Conjugate typhoid vaccines in India: Two Different Vi-PS conjugate vaccines have been licensed in India. \n" +
                        "\n" +
                        "1. Vi-PS Conjugate Vaccine Conjugated with Tetanus Toxoid (Pedatyph ) by Bio-Med Pvt. Ltd. \n" +
                        "\n" +
                        "2. Vi-polysaccharide conjugate vaccine conjugated with Tetanus Toxoid from Bharat Biotech(Typbar-TCV ) \n" +
                        "\n" +
                        "Minimum Age: \n" +
                        "\n" +
                        "Vi-PS (Polysaccharide) Vaccines: 2 years \n" +
                        "\n" +
                        "Vi-PS (Typbar-TCV): 6 months \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Recommended Schedule \n" +
                        "\n" +
                        "Vi-PS (polysaccharide) vaccines: Single dose at 2 years; Revaccination every 3 years; (No evidence of hypo-responsiveness on repeated revaccination so far). Vi-PS Conjugate (Typbar-TCV): Single dose at 9 to 12 months and a booster during second year of life Vi-PS Conjugate vaccine (PedaTyph): Data not sufficient to recommend for routine use. \n" +
                        "\n" +
                        "Note: \n" +
                        "\n" +
                        "Since and the incompatibility data with measles vaccine is not available, there should be an interval of at least 4 weeks either before or after the former. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        " "
            )
        )
        myArr.add(
            InfoData(
                "MEASLES, MUMPS AND RUBELLA VACCINES (MMR) ",
                "Rubella per se a mild exanthematous illness but if acquired in the first trimester of pregnancy can lead to disastrous consequences in the fetus/ new born such as abortion, still birth, mental retardation, congenital heart disease, blindness and cataract. Hence the objective of vaccination against rubella is protection against congenital rubella syndrome (CRS). Rubella vaccine currently derived from RA 27/3 vaccine strain grown in human diploid/chick embryo cell cultures recommends the use of MMR vaccine instead of monovalent rubella vaccine or MR vaccine so as to provide additional protection against mumps and measles. \n" +
                        "\n" +
                        "Minimum age: 12 months \n" +
                        "\n" +
                        "Recommended Schedule \n" +
                        "\n" +
                        "First dose of MMR vaccine at age 12 through 18 months, and the second dose at age 4 through 6 years. The second dose may be administered before age 4 years, provided at least 4 weeks have elapsed since the first dose \n" +
                        "\n" +
                        " "
            )
        )
        myArr.add(
            InfoData(
                "VARICELLA VACCINE ",
                "Varicella (chickenpox) is a febrile rash illness resulting from primary infection with the varicella zoster virus (VZV). Humans are the only source of infection for this virus. It has been recommended to offer the vaccine to all healthy children with no prior history of varicella. \n" +
                        "\n" +
                        "Minimum Age: 12 months \n" +
                        "\n" +
                        "Recommended Schedule \n" +
                        "\n" +
                        "For primary immunization, the first dose should be given at the age of 15 months and the second dose at 4 to 6 years. The second dose may be administered any time 3 months after the first dose The second dose was administered at least 4 weeks after the first dose, it can be accepted as valid. All high risk children should, however, receive two doses 4 to 8 weeks apart irrespective of age The risk of breakthrough varicella is lower if given 15 months onwards. \n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        " "
            )
        )
        myArr.add(
            InfoData(
                "HEPATITIS A VACCINES (Hep A) ",
                "Hepatitis A virus (HAV) infection is a relatively benign infection in young children. As many as 85% of children below 2 years and 50% of those between 2 and 5 years infected with HAV are anicteric and may have no symptoms at all or just have non-specific symptoms like fever, malaise, diarrhea, vomiting, cough, etc. like any other viral infection \n" +
                        "\n" +
                        "Minimum age: 12 months \n" +
                        "\n" +
                        "Recommended Schedule \n" +
                        "\n" +
                        "2-dose hepatitis A vaccine series are recommended for children aged 12 through 23 months; Children, who have received 1 dose of hepatitis A vaccine before age 24 months, should receive a second dose 6 to 18 months after the first dose. Two doses of both killed and live hepatitis A vaccines as of now "
            )
        )

        rv!!.adapter = myAdapter
        rv!!.itemAnimator = DefaultItemAnimator()
        rv!!.layoutManager = myLayoutManager1
        return v
    }
}


