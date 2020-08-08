package com.acrylic.acrylicutils.Commands;

import com.acrylic.version_latest.Items.Utils.ItemUtils;
import com.acrylic.version_latest.Probability.Probability;
import com.acrylic.version_latest.Utils.StringConverters.LocationString;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

public class TestCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        Bukkit.broadcastMessage(new ItemUtils(p.getItemInHand()).getDisplayName());
        /**MongoClient client = AcrylicUtils.getMongoClient();
        Morphia morphia = new Morphia().map(EntityTest.class);

        EntityTest test = new EntityTest("Test","TFJ","TVFV",100);

        //test.setAddress(new ItemCreator(Material.ICE));
        Bukkit.broadcastMessage("Test 2");
        Datastore datastore = morphia.createDatastore(client,"Database");
        datastore.ensureIndexes();
        Bukkit.broadcastMessage("Test 3");
        datastore.save(test);
        Bukkit.broadcastMessage("Test CCC");
        /**MongoDatabase testDB = client.getDatabase(args[0]);
        Bukkit.broadcastMessage("Test " + testDB);
        try {
            testDB.createCollection(args[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        MongoCollection<Document> docs = testDB.getCollection(args[1]);
        Document document = new Document("Test",1).append("Lol",new ItemCreator(Material.DIAMOND_SWORD).getItem()).append("Sjitf",new ArrayList<>());
        docs.insertOne(document);

        Bukkit.broadcastMessage("Test 2");

        Bukkit.broadcastMessage(testDB.getName() + "");
        /**ItemDangle itemDangle = new ItemDangle(p);
        for (int i = 1;i<=Integer.parseInt(args[0]);i++) {
            EntityAnimator entityManager = new GiantAnimator(center);
            entityManager.setEntityEquipment(
                    new EntityEquipment(entityManager.getEntity()).setItemInMainHand(p.getItemInHand()));
            HandRotatorAnimation d = new HandRotatorAnimation(entityManager);
            d.setHologram("&6&lLevel Up!","&eYou are a cunt","&eA genuine cuck.");
            itemDangle.addAnimator(d);
        }
        new BukkitRunnable() {

            int i = 0;

            @Override
            public void run() {
                itemDangle.update();
                if (i % 25 == 0) {
                    itemDangle.delete(itemDangle.getAnimators().get(0));
                }
                if (i > 200) {
                    itemDangle.delete();
                }
                i++;
            }
        }.runTaskTimer(AcrylicUtils.getAcrylicUtils(), 1, 1);
**/

         return true;
    }


   
}
