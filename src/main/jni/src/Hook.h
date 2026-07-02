#ifndef ANDROID_MOD_MENU_HOOK_H
#define ANDROID_MOD_MENU_HOOK_H
#include <src/Unity/Vector3.hpp>
#include <src/Unity/Quaternion.hpp>
#include <src/Unity/Vector2.hpp>
#include "Global.h"
using namespace std;

//
long AfindLibrary(const char *library) {
    char filename[0xFF] = {0},
    buffer[1024] = {0};
    FILE *fp = nullptr;
    long address = 0;

    sprintf(filename, "/proc/self/maps");

    fp = fopen( filename, "rt" );
    if( fp == nullptr ){
        perror("fopen");
        goto done;
    }

    while( fgets( buffer, sizeof(buffer), fp ) ) {
        if(strstr( buffer, library ) ){
            address = (long)strtoul( buffer, NULL, 16 );
            goto done;
        }
    }

    done:

    if(fp){
        fclose(fp);
    }

    return address;
}

long ClibBase;

long AgetAbsoluteAddress(const char* libraryName, long relativeAddr) {
    if (ClibBase == 0) {
        ClibBase = AfindLibrary(libraryName);
        if (ClibBase == 0) {
            ClibBase = 0;
        }
    }
    return ClibBase + relativeAddr;
}

/*-------Vector3 Class-------*/
class Vvector3 {
public:
    float X;
    float Y;
    float Z;
    Vvector3() : X(0), Y(0), Z(0) {}
    Vvector3(float x1, float y1, float z1) : X(x1), Y(y1), Z(z1) {}
    Vvector3(const Vvector3 &v);
    ~Vvector3();
};
Vvector3::Vvector3(const Vvector3 &v) : X(v.X), Y(v.Y), Z(v.Z) {}
Vvector3::~Vvector3() {}


/*-------Bool playes-------*/
bool (*AttackableEntity_GetIsDead)(void *attackableEntity) = (bool (*)(void *))getRealOffset(Global.GetIsDead);
void* (*getPlayerByIndex)(void* match, uint8_t index) = (void*(*)(void *, uint8_t))getRealOffset(Global.Player_Index);
bool (*getIsDead)(void *EntityIsDead) = (bool *(*)(void *))getRealOffset(Global.GetIsDead);

static void *GetLocalPlayer(void* Match) {
    void *(*_GetLocalPlayer)(void *match) = (void *(*)(void *))getRealOffset(Global.GetLocalPlayer);
    return _GetLocalPlayer(Match);
}

static bool get_AttackableEntity_GetIsDead(void *player) {
    bool (*_get_AttackableEntity_GetIsDead)(void *players) = (bool (*)(void *))getRealOffset(Global.GetIsDead);
    return _get_AttackableEntity_GetIsDead(player);
}
	
static bool get_isAlive(void *player) {
    bool (*_get_isAlive)(void *players) = (bool (*)(void *))getRealOffset(Global.get_isAlive);
    return _get_isAlive(player);
}

static bool get_isLocalTeam(void *player) {
    bool (*_get_isLocalTeam)(void *players) = (bool (*)(void *))getRealOffset(Global.get_isLocalTeam);
    return _get_isLocalTeam(player);
}

static Vector3 GetAttackableCenterWS(void *player) {
    Vector3 (*_GetAttackableCenterWS)(void *players) = (Vector3 (*)(void *))getRealOffset(Global.GetAttackableCenterWS);
    return _GetAttackableCenterWS(player);
}

static bool get_IsDieing(void *player) {
    bool (*_get_die)(void *players) = (bool (*)(void *))getRealOffset(Global.get_IsDieing);
    return _get_die(player);
}

static bool IsClientBot(void *player) {
    bool (*_IsClientBot)(void *players) = (bool (*)(void *))getRealOffset(Global.IsClientBot);
    return _IsClientBot(player);
}

static void *Current_Local_Player() {
    void *(*_Local_Player)(void *players) = (void *(*)(void *))getRealOffset(Global.Current_Local_Player);
    return _Local_Player(nullptr);
}

static void *GetLocalPlayerOrObServer() {
    void *(*_GetLocalPlayerOrObServer)(void *players) = (void *(*)(void *))getRealOffset(Global.GetLocalPlayerOrObServer);
    return _GetLocalPlayerOrObServer(NULL);
}

static bool get_IsDriver(void *player) {
    bool (*_IsDriver)(void *players) = (bool (*)(void *))getRealOffset(Global.get_Driver);
    return _IsDriver(player);
}


/*-------Hps-------*/
static int get_MaxHP(void* enemy) {
	int (*_get_MaxHP)(void* player) = (int(*)(void *))getRealOffset(Global.get_MaxHP);
	return _get_MaxHP(enemy);
}
	
static int GetHp(void* player) {
    int (*_GetHp)(void* players) = (int (*)(void *))getRealOffset(Global.get_CurHP);
    return _GetHp(player);
}


/*-------MonoString Names Etc-------*/
static monoString *U3DStr(const char *str) {
    monoString *(*String_CreateString)(void *_this, const char *str) = (monoString * (*)(void *, const char *))getRealOffset(Global.U3DStr);
    return String_CreateString(nullptr, str);
}

static char get_Chars(monoString* names, int indexs) {
    char (*_get_Chars)(monoString *name, int index) = (char (*)(monoString*, int))getRealOffset(Global.get_Chars);
    return _get_Chars(names, indexs);
}

static void *CurrentUIScene() {
    void *(*_CurrentUIScene)(void *nuls) = (void *(*)(void *))getRealOffset(Global.CurrentUIScene);
    return _CurrentUIScene(nullptr);
}

static monoString* get_NickName(void *player) {
    monoString* (*_get_NickName)(void *players) = (monoString * (*)(void *))getRealOffset(Global.get_NickName);
    return  _get_NickName(player);
}

static void ShowAssistantText(void *player, monoString *nick, monoString *grup) {
    void (*_ShowAssistantText)(void *players, monoString * nicks, monoString * nickss) = (void (*)(void *, monoString *, monoString *))getRealOffset(Global.ShowAssistantText);
    void *ui = CurrentUIScene();
    if (ui != nullptr) {
        _ShowAssistantText(player, nick, grup);
    }
}

static monoString* get_weapon(string *player) {
    monoString* (*_get_weapon)(void *players) = (monoString * (*)(void *))getRealOffset(0x815E30);
    return  _get_weapon(player);
}



/*-------Char MonoString Names-------*/

static monoString *FormatCount(int enemy, int bot) {
    char buf[128] = {};
    sprintf(buf, " Inimigos: %d  Bots: %d", enemy, bot);
    return U3DStr(buf);
}

static monoString *BrunoMods1(float distance) {
    char buffer[128] = {0};
    sprintf(buffer, "[ %.2f M JOGADOR REAL ]", distance);
    return U3DStr(buffer);
}

static monoString *DistBrunoMods(float distance) {
    char dist[128] = {0};
    sprintf(dist, " %.2f M ", distance);
    return U3DStr(dist);
}


static monoString *BrunoMods2(float distance) {
    char bots[128] = {0};
    sprintf(bots, "[ %.2f M BOT ]", distance);
    return U3DStr(bots);
}

static monoString *BrunoMods3(float distance) {
    char fire[128] = {0};
    sprintf(fire, "[ %.2f M JOGADOR REAL =  Atirando ]", distance);
    return U3DStr(fire);
}

static monoString *BrunoMods4(float distance) {
    char mira[128] = {0};
    sprintf(mira, "[ %.2f M JOGADOR REAL =  Mirando ]", distance);
    return U3DStr(mira);
}

static monoString *BrunoMods5(float distance) {
    char drive[128] = {0};
    sprintf(drive, "[ %.2f M JOGADOR REAL =  No veiculo ]", distance);
    return U3DStr(drive);
}

static monoString *BrunoMods6(float distance) {
    char kit[128] = {0};
    sprintf(kit, "[ %.2f M JOGADOR REAL =  Se Curando ]", distance);
    return U3DStr(kit);
}

static monoString *BrunoMods7(float distance) {
    char aliado[128] = {0};
    sprintf(aliado, "[ %.2f M JOGADOR REAL =  Sufando no ceu ]", distance);
    return U3DStr(aliado);
}

static monoString *BrunoMods8(float distance) {
    char aliado[128] = {0};
    sprintf(aliado, "[ %.2f M JOGADOR REAL =  No paraquedas ]", distance);
    return U3DStr(aliado);
}

static monoString *BrunoMods9(float distance) {
    char aliado[128] = {0};
    sprintf(aliado, "[ %.2f M JOGADOR REAL =  Rastejando ]", distance);
    return U3DStr(aliado);
}

static monoString *BrunoMods10(float distance) {
    char aliado[128] = {0};
    sprintf(aliado, "[ %.2f M JOGADOR REAL =  Nadando ]", distance);
    return U3DStr(aliado);
}

static monoString *BrunoMods11(float distance) {
    char aliado[128] = {0};
    sprintf(aliado, "[ %.2f M JOGADOR REAL =  Salvando aliado ]", distance);
    return U3DStr(aliado);
}

static monoString *BrunoMods12(float distance) {
    char aliado[128] = {0};
    sprintf(aliado, "[ %.2f M JOGADOR REAL =  Usando Inalador ]", distance);
    return U3DStr(aliado);
}

static monoString *BrunoMods13(float distance) {
    char aliado[128] = {0};
    sprintf(aliado, "[ %.2f M JOGADOR REAL = Agachado ]", distance);
    return U3DStr(aliado);
}

static monoString *BrunoMods14(float distance) {
    char aliado[128] = {0};
    sprintf(aliado, "[ %.2f M JOGADOR REAL = Com Granada ]", distance);
    return U3DStr(aliado);
}

static monoString *BrunoMods15(float distance) {
    char aliado[128] = {0};
    sprintf(aliado, "[ %.2f M JOGADOR REAL = faca de arremesso ]", distance);
    return U3DStr(aliado);
}

static monoString *BrunoMods16(float distance) {
    char aliado[128] = {0};
    sprintf(aliado, "[ %.2f M JOGADOR REAL = Usando Camuflagem ]", distance);
    return U3DStr(aliado);
}

/*------SetWidht------*/

int (*SWidth)() = (int(*)())getRealOffset(Global.get_width);
int (*SHeight)() = (int(*)())getRealOffset(Global.get_height);

/*-------LineRedere-------*/
static void LineRenderer_SetPosition(void *Render, int value, Vector3 Location){
    void (*_LineRenderer_SetPosition)(void *Render, int value, Vector3 Location) = (void (*)(void*, int, Vector3))getRealOffset(Global.LineRenderer_SetPosition);
    return _LineRenderer_SetPosition(Render, value, Location);
}

static void LineRenderer_Set_PositionCount(void *Render, int value){
    void (*_LineRenderer_Set_PositionCount)(void *Render, int value) = (void (*)(void*, int))getRealOffset(Global.LineRenderer_Set_PositionCount);
    return _LineRenderer_Set_PositionCount(Render, value);
}

static void GrenadeLine_DrawLine(void *instance, Vector3 start, Vector3 end, Vector3 position) {
    void (*_GrenadeLine_DrawLine)(void *clz, Vector3 throwPos, Vector3 throwVel, Vector3 gravity) = (void (*)(void*, Vector3, Vector3,Vector3)) getRealOffset(Global.GrenadeLine_DrawLine);
    return _GrenadeLine_DrawLine(instance, start, end, position);
}

/*-------GetSartActive Fire-------*/
static void *get_imo(void *player) {
    void *(*_get_imo)(void *players) = (void *(*)(void *))getRealOffset(Global.get_imo);
    return _get_imo(player);
}

static void set_esp1(void *imo, Vector3 x, Vector3 y) {
    void (*_set_esp1)(void *imo, Vector3 X, Vector3 Y) = (void (*)(void *, Vector3, Vector3))getRealOffset(Global.set_esp1);
    _set_esp1(imo, x, y);
}

static void set_esp(void *imo, Vector3 x, Vector3 y) {
    void (*_set_esp)(void *imo, Vector3 X, Vector3 Y) = (void (*)(void *, Vector3, Vector3))getRealOffset(Global.set_esp);
    _set_esp(imo, x, y);
}

/*-------Parte do aimbot-------*/
static bool get_IsFiring(void *player) {
    bool (*_get_IsFiring)(void *players) = (bool (*)(void *))getRealOffset(Global.get_IsFiring);
    return _get_IsFiring(player);
}

static bool get_IsSighting(void *player) {
    bool (*_get_IsSighting)(void *players) = (bool (*)(void *))getRealOffset(Global.get_IsSighting);
    return _get_IsSighting(player);
}

static bool get_IsCrouching(void *player) {
    bool (*_get_IsCrouching)(void *players) = (bool (*)(void *))getRealOffset(Global.get_IsCrouching);
    return _get_IsCrouching(player);
}

static bool get_isVisible(void *player) {
    bool (*_get_isVisible)(void *players) = (bool (*)(void *))getRealOffset(Global.get_isVisible);
    return _get_isVisible(player);
}

static Vector3 GetForward(void *player) {
    Vector3 (*_GetForward)(void *players) = (Vector3 (*)(void *))getRealOffset(Global.GetForward);
    return _GetForward(player);
}

static void set_aim(void *player, Quaternion look) {
    void (*_set_aim)(void *players, Quaternion lock) = (void (*)(void *, Quaternion))getRealOffset(Global.set_aim);
    _set_aim(player, look);
}


/*-------Transform-------*/
static Vector3 Transform_INTERNAL_GetPosition(void *player) {
    Vector3 out = Vector3::Zero();
    void (*_Transform_INTERNAL_GetPosition)(void *transform, Vector3 * out) = (void (*)(void *, Vector3 *))getRealOffset(Global.Transform_INTERNAL_GetPosition);
    _Transform_INTERNAL_GetPosition(player, &out);
    return out;
}

static void Set_Position(void *player, Vvector3 inn) {
    void (*Set_Position)(void *transform, Vvector3 in) = (void (*)(void *, Vvector3))getRealOffset(Global.Transform_INTERNAL_SetPosition);
    Set_Position(player, inn);
}

static void *Component_GetTransform(void *player) {
    void *(*_Component_GetTransform)(void *component) = (void *(*)(void *))getRealOffset(Global.Component_GetTransform);
    return _Component_GetTransform(player);
}

/*-------Cameras-------*/
static void *Camera_main() {
    void *(*_Camera_main)(void *nuls) = (void *(*)(void *))getRealOffset(Global.Camera_main);
    return _Camera_main(nullptr);
}

static void *get_MyFollowCamera(void *players) {
    void *(*_get_MyFollowCamera) (void *player) = (void *(*)(void *))getRealOffset(Global.get_MyFollowCamera);
    return _get_MyFollowCamera(players);
}

static void *Curent_Match() {
    void *(*_Curent_Match) (void *nuls) = (void *(*)(void *))getRealOffset(Global.Curent_Match);
    return _Curent_Match(NULL);
}


/*-------Poups-------*/
static void ShowDynamicPopupMessage(monoString *nick) {
    void (*_ShowDynamicPopupMessage)(void *players, monoString * nicks, float duration) = (void (*)(void *, monoString *, float))getRealOffset(Global.ShowDynamicPopupMessage);
    void *ui = CurrentUIScene();
    if (ui != NULL) {
        _ShowDynamicPopupMessage(ui, nick, 0.1f);
    }
}

void (*ShowPopupMessage)(void *players, void * nicks, float duration) = (void (*)(void *, void *, float))getRealOffset(Global.ShowPopupMessage);
void (*String_Concat)(void *_null, void *_this,void* str1, void* str2) = (void (*)(void*,void*,void*, void*))getRealOffset(Global.String_Concat);

static void ShowPopupMessages(monoString *nick) {
    void (*_ShowPopupMessage)(void *players, monoString * nicks, float duration) = (void (*)(void *, monoString *, float))getRealOffset(Global.ShowPopupMessage);
    void *ui = CurrentUIScene();
    if (ui != nullptr) {
        _ShowPopupMessage(ui, nick, 0.1f);
    }
}

static void BrunoModsString(void *player, monoString *nick, monoString *grup, float duration) {
    void (*_BrunoModsString)(void *players, monoString * nicks, monoString * nickss, float duration) = (void (*)(void *, monoString *, monoString *, float))getRealOffset(Global.ShowPopupMessage);
    void *ui = CurrentUIScene();
    if (ui != nullptr) {
        _BrunoModsString(player, nick, grup, 0.1f);
    }
}


//Alerta

static bool get_Tiro(void *player) {
    bool (*_get_Tiro)(void *players) = (bool (*)(void *))getRealOffset(Global.get_Firing);
    return _get_Tiro(player);
}

static bool get_Mira(void *player) {
    bool (*_get_Mira)(void *players) = (bool (*)(void *))getRealOffset(Global.get_Sighting);
    return _get_Mira(player);
}

static bool get_Driv(void *player) {
    bool (*_get_Driv)(void *players) = (bool (*)(void *))getRealOffset(Global.get_Driver);
    return _get_Driv(player);
}

static bool get_KitM(void *player) {
    bool (*_get_KitM)(void *players) = (bool *(*)(void *))getRealOffset(Global.get_Kitmedico);
    return _get_KitM(player);
}

static bool get_Skat(void *player) {
    bool (*_get_Skat)(void *players) = (bool *(*)(void *))getRealOffset(Global.get_SkySurfing);
    return _get_Skat(player);
}

static bool get_Prch(void *player) {
    bool (*_get_Prch)(void *players) = (bool *(*)(void *))getRealOffset(Global.get_Parachuting);
    return _get_Prch(player);
}

static bool get_Crep(void *player) {
    bool (*_get_Crep)(void *players) = (bool *(*)(void *))getRealOffset(Global.get_IsCreep);
    return _get_Crep(player);
}

static bool get_Swig(void *player) {
    bool (*_get_Swig)(void *players) = (bool *(*)(void *))getRealOffset(Global.get_IsSwimming);
    return _get_Swig(player);
}

static bool get_Alid(void *player) {
    bool (*_get_Alid)(void *players) = (bool *(*)(void *))getRealOffset(Global.get_IsRescureing);
    return _get_Alid(player);
}

static bool get_Croc(void *player) {
    bool (*_get_Croc)(void *players) = (bool *(*)(void *))getRealOffset(Global.get_Crouching);
    return _get_Croc(player);
}

static bool get_Grnd(void *player) {
    bool (*_get_Grnd)(void *players) = (bool *(*)(void *))getRealOffset(Global.get_IsGrenadeStart);
    return _get_Grnd(player);
}

static bool get_Knif(void *player) {
    bool (*_get_Knif)(void *players) = (bool *(*)(void *))getRealOffset(Global.get_IsThrowingKnifeStart);
    return _get_Knif(player);
}

static bool get_Cmfg(void *player) {
    bool (*_get_Cmfg)(void *players) = (bool *(*)(void *))getRealOffset(Global.get_IsWearingCamouflage);
    return _get_Cmfg(player);
}

//Weapon
static int GetWeaponType(void* player) {
    int (*_GetWeaponType)(void* p) = (int (*)(void* ))getRealOffset(Global.GetWeaponType);
    return _GetWeaponType(player);
}

static char* NameWeapon(int weapon) {
    if (weapon == 0) {
        return "Rifle";
    } else if (weapon == 1) {
        return "Sniper";
    } else if (weapon == 2) {
        return "Pistola";
    } else if (weapon == 3) {
        return "Punho";
    } else if (weapon == 4) {
        return "Espingarda";
    } else if (weapon == 5) {
        return "Granada";
    } else if (weapon == 6) {
        return "Metralhadora";
    } else if (weapon == 7) {
        return "lança granada";
    } else if (weapon == 8) {
        return "CrossBow";
    } else if (weapon == 9) {
        return "Gelo";
    } else if (weapon == 10) {
        return "Metralhadora externa";
    } else if (weapon == 11) {
        return "Pistola de cura";
    } else if (weapon == 12) {
        return "Arma de carga";
    } else if (weapon == 13) {
        return "Arma Pesada";
    } else if (weapon == 14) {
        return "Lata de Spawn";
    } else if (weapon == 15) {
        return "Arma de Gancho";
    } else if (weapon == 16) {
        return "Canhão de mão";
    } else if (weapon == 17) {
        return "Sprayer de tinta";
    } else if (weapon == 18) {
        return "Faca de arremesso";
    } else if (weapon == 19) {
        return "Arma De gelo";
    } else if (weapon == 20) {
        return "Equipamentos";
    } else if (weapon == 21) {
        return "Arma de spray";
    } else if (weapon == 22) {
        return "Faca de arremesso BR";
    } else if (weapon == 23) {
        return "Arma Nb";
    } else if (weapon == 24) {
        return "Arma Falsa";
    } else if (weapon == 25) {
        return "Arma falsa v2";
    } else if (weapon == 255) {
        return "Para Todos";
    }
}



/*--- 360 ---*/
int isOutsideSafezone(Vector3 pos, Vector3 screen) {
    Vector3 mSafezoneTopLeft(screen.X * 0.04f, screen.Y * 0.04f);
    Vector3 mSafezoneBottomRight(screen.X * 0.96f, screen.Y * 0.96f);

    int result = 0;
    if (pos.Y < mSafezoneTopLeft.Y) {
        result |= 1;
    }
    if (pos.X > mSafezoneBottomRight.X) {
        result |= 2;
    }
    if (pos.Y > mSafezoneBottomRight.Y) {
        result |= 4;
    }
    if (pos.X < mSafezoneTopLeft.X) {
        result |= 8;
    }
    return result;
}

Vector3 pushToScreenBorder(Vector3 Pos, Vector3 screen, int borders, int offset) {
    int x = (int)Pos.X;
    int y = (int)Pos.Y;
    if ((borders & 1) == 1) {
        y = 0 - offset;
    }
    if ((borders & 2) == 2) {
        x = (int)screen.X + offset;
    }
    if ((borders & 4) == 4) {
        y = (int)screen.Y + offset;
    }
    if ((borders & 8) == 8) {
        x = 0 - offset;
    }
    return Vector3(x, y);
}



/*case 47:
		    ChamsCor = !ChamsCor;
            if (Value == 1) {
            Set_Cham_Color(bruno_chams.red);     
			
            } else if (Value == 2) {
            Set_Cham_Color(bruno_chams.green);
			
            } else if (Value == 3) {
            Set_Cham_Color(bruno_chams.blue);      
			
            } else if (Value == 4) {
            Set_Cham_Color(bruno_chams.white);     
			
            } else if (Value == 5) {
            Set_Cham_Color(bruno_chams.black);     
			
            } else if (Value == 6) {
            Set_Cham_Color(bruno_chams.purpleSense);     
			
            } else if (Value == 7) {
            Set_Cham_Color(bruno_chams.yellow);       
			
            } else if (Value == 8) {
            Set_Cham_Color(bruno_chams.magenta);  
			
            } else if (Value == 9) {
            Set_Cham_Color(bruno_chams.gray);       
			
            } else {
            Disable_Cham();       
            }
            break; 
				*/


#endif
