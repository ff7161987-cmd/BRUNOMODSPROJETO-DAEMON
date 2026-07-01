#ifndef ESP_H
#define ESP_H

bool isEspReady();
void EspDraw(void *camera, void *local_player, void *enemy_player);
void EspSetEnemyAndBotAll(int enemy_count, int bot_count);
void EspSetEnemyAndBotNear(int enemy_count, int bot_count);
void EspDrawEnemyAndBotAll(bool onORoff);
void EspDrawEnemyAndBotNear(bool onORoff);
void EspDrawWeaponEnemy(bool onORoff);
void EspDrawLine(bool onORoff);
void EspDrawDistance(bool onORoff);
void EspDrawName(bool onORoff);
void EspDrawBox(bool onORoff);
void EspDrawSkeleton(bool onORoff);
void EspDrawAlert360(bool onORoff);
void setEspReady(bool isEnd);

#endif