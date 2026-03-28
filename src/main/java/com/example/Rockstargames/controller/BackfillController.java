package com.example.Rockstargames.controller;

import com.example.Rockstargames.utill.APIResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("api/v1/backfill")
public class BackfillController {

    @PersistenceContext
    private EntityManager em;

    private static final String[][] GAME_META = {
        {"1",  "Grand Theft Auto V",          "Rs 2999.00", "Assests/gta v.png"},
        {"2",  "Red Dead Redemption 2",        "Rs 3999.00", "Assests/rdr 2.png"},
        {"3",  "GTA Online",                   "Rs 1999.00", "Assests/gta online.png"},
        {"4",  "Grand Theft Auto IV",          "Rs 1999.00", "Assests/gta iv.jpg"},
        {"5",  "GTA: San Andreas",             "Rs 1499.00", "Assests/gta sanAndreas.webp"},
        {"6",  "Grand Theft Auto: Vice City",  "Rs 1299.00", "Assests/gta vice city.jpg"},
        {"7",  "Grand Theft Auto III",         "Rs 999.00",  "Assests/gta 3.jpg"},
        {"8",  "Red Dead Redemption",          "Rs 2499.00", "Assests/rdr1.jpg"},
        {"9",  "L.A. Noire",                   "Rs 1499.00", "Assests/La Noire.png"},
        {"10", "Bully: Scholarship Edition",   "Rs 999.00",  "Assests/bullyScolership.png"},
        {"11", "Max Payne 3",                  "Rs 1999.00", "Assests/max pain 3.webp"},
        {"12", "Max Payne 2",                  "Rs 999.00",  "Assests/Maxpain 2.png"},
        {"13", "Manhunt",                      "Rs 799.00",  "Assests/manhunt.png"},
        {"14", "The Warriors",                 "Rs 899.00",  "Assests/Tha warriors.webp"},
        {"15", "Midnight Club: Los Angeles",   "Rs 899.00",  "Assests/Midnight Club-Los_Angeles.jpg"},
        {"16", "GTA: Chinatown Wars",          "Rs 699.00",  "Assests/ChinatownWars.jpg"},
        {"17", "Rockstar Games: Table Tennis", "Rs 499.00",  "Assests/rockstartable tennis.jpg"},
        {"18", "GTA: Liberty City Stories",    "Rs 899.00",  "Assests/gta libertycitystories.png"},
        {"19", "GTA: Vice City Stories",       "Rs 999.00",  "Assests/gta vice city stories.jpg"},
        {"20", "Manhunt 2",                    "Rs 799.00",  "Assests/Manhunt 2.jpg"}
    };


    @PostMapping("/user-games")
    @Transactional
    public ResponseEntity<APIResponse<String>> backfill() {

        int inserted = 0;
        int skipped  = 0;

        try {
            // ── Fetch all orders ──────────────────────────────────────────────
            // ADJUST these column names to match YOUR orders table:
            //   customer_id → the username / JWT subject stored in orders
            //   game_id     → the numeric game ID ("1"–"20")
            //   price       → the price string
            @SuppressWarnings("unchecked")
            List<Object[]> orders = em.createNativeQuery(
                "SELECT customer_id, game_id, price FROM orders"
            ).getResultList();

            for (Object[] row : orders) {
                String username = String.valueOf(row[0]);
                String gameId   = String.valueOf(row[1]);
                String price    = row[2] != null ? String.valueOf(row[2]) : "";

                // Resolve title + imageUrl from the static lookup
                String title    = "Unknown Game";
                String imageUrl = "";
                for (String[] meta : GAME_META) {
                    if (meta[0].equals(gameId)) {
                        title    = meta[1];
                        imageUrl = meta[3];
                        break;
                    }
                }

                Long exists = (Long) em.createNativeQuery(
                    "SELECT COUNT(*) FROM user_games WHERE username = ?1 AND game_id = ?2"
                ).setParameter(1, username).setParameter(2, gameId)
                 .getSingleResult();

                if (exists > 0) { skipped++; continue; }

                em.createNativeQuery(
                    "INSERT INTO user_games (username, game_id, game_title, game_price, image_url, purchased_date) " +
                    "VALUES (?1, ?2, ?3, ?4, ?5, ?6)"
                )
                .setParameter(1, username)
                .setParameter(2, gameId)
                .setParameter(3, title)
                .setParameter(4, price)
                .setParameter(5, imageUrl)
                .setParameter(6, LocalDate.now())
                .executeUpdate();

                inserted++;
            }

            String msg = "Backfill complete. Inserted: " + inserted + ", Skipped (already existed): " + skipped;
            return new ResponseEntity<>(new APIResponse<>(200, msg, null), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(
                new APIResponse<>(500, "Backfill failed: " + e.getMessage(), null),
                HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
