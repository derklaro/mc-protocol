# Release 1.19.2, Protocol 760
## Handshaking (Server -> Client)


## Handshaking (Client -> Server)

#### 0x00 - Client Intention Packet
| Type | Name |
| -------------| -------------|
| int| protocol version|
| ConnectionProtocol| intention|
| String| host name|
| int| port|



## Play (Server -> Client)

#### 0x00 - Add Entity Packet
| Type | Name |
| -------------| -------------|
| EntityType\<?\>| type|
| UUID| uuid|
| int| ya|
| byte| x rot|
| int| xa|
| byte| y rot|
| int| za|
| int| data|
| double| z|
| int| id|
| double| x|
| double| y|
| byte| y head rot|

#### 0x01 - Add Experience Orb Packet
| Type | Name |
| -------------| -------------|
| double| y|
| double| x|
| int| id|
| double| z|
| int| value|

#### 0x02 - Add Player Packet
| Type | Name |
| -------------| -------------|
| byte| y rot|
| double| y|
| double| x|
| byte| x rot|
| int| entity id|
| double| z|
| UUID| player id|

#### 0x03 - Animate Packet
| Type | Name |
| -------------| -------------|
| int| id|
| int| action|

#### 0x04 - Award Stats Packet
| Type | Name |
| -------------| -------------|
| Object2IntMap\<Stat\<?\>\>| stats|

#### 0x05 - Block Changed Ack Packet
| Type | Name |
| -------------| -------------|
| int| sequence|

#### 0x06 - Block Destruction Packet
| Type | Name |
| -------------| -------------|
| int| id|
| int| progress|
| BlockPos| pos|

#### 0x07 - Block Entity Data Packet
| Type | Name |
| -------------| -------------|
| CompoundTag| tag|
| BlockEntityType\<?\>| type|
| BlockPos| pos|

#### 0x08 - Block Event Packet
| Type | Name |
| -------------| -------------|
| Block| block|
| int| b1|
| int| b0|
| BlockPos| pos|

#### 0x09 - Block Update Packet
| Type | Name |
| -------------| -------------|
| BlockState| block state|
| BlockPos| pos|

#### 0x0A - Boss Event Packet
| Type | Name |
| -------------| -------------|
| Operation| operation|
| UUID| id|

#### 0x0B - Change Difficulty Packet
| Type | Name |
| -------------| -------------|
| boolean| locked|
| Difficulty| difficulty|

#### 0x0C - Chat Preview Packet
| Type | Name |
| -------------| -------------|
| int| query id|
| Component| preview|

#### 0x0D - Clear Titles Packet
| Type | Name |
| -------------| -------------|
| boolean| reset times|

#### 0x0E - Command Suggestions Packet
| Type | Name |
| -------------| -------------|
| int| id|
| Suggestions| suggestions|

#### 0x0F - Commands Packet
| Type | Name |
| -------------| -------------|
| List\<Entry\>| entries|
| int| root index|

#### 0x10 - Container Close Packet
| Type | Name |
| -------------| -------------|
| int| container id|

#### 0x11 - Container Set Content Packet
| Type | Name |
| -------------| -------------|
| int| state id|
| List\<ItemStack\>| items|
| ItemStack| carried item|
| int| container id|

#### 0x12 - Container Set Data Packet
| Type | Name |
| -------------| -------------|
| int| id|
| int| container id|
| int| value|

#### 0x13 - Container Set Slot Packet
| Type | Name |
| -------------| -------------|
| int| state id|
| ItemStack| item stack|
| int| container id|
| int| slot|

#### 0x14 - Cooldown Packet
| Type | Name |
| -------------| -------------|
| int| duration|
| Item| item|

#### 0x15 - Custom Chat Completions Packet
| Type | Name |
| -------------| -------------|
| Action| action|
| List\<String\>| entries|

#### 0x16 - Custom Payload Packet
| Type | Name |
| -------------| -------------|
| ResourceLocation| identifier|
| FriendlyByteBuf| data|

#### 0x17 - Custom Sound Packet
| Type | Name |
| -------------| -------------|
| SoundSource| source|
| float| pitch|
| int| z|
| int| y|
| ResourceLocation| name|
| int| x|
| long| seed|
| float| volume|

#### 0x18 - Delete Chat Packet
| Type | Name |
| -------------| -------------|
| MessageSignature| message signature|

#### 0x19 - Disconnect Packet
| Type | Name |
| -------------| -------------|
| Component| reason|

#### 0x1A - Entity Event Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| byte| event id|

#### 0x1B - Explode Packet
| Type | Name |
| -------------| -------------|
| double| z|
| float| power|
| double| x|
| double| y|
| float| knockback x|
| List\<BlockPos\>| to blow|
| float| knockback y|
| float| knockback z|

#### 0x1C - Forget Level Chunk Packet
| Type | Name |
| -------------| -------------|
| int| z|
| int| x|

#### 0x1D - Game Event Packet
| Type | Name |
| -------------| -------------|
| float| param|
| Type| event|

#### 0x1E - Horse Screen Open Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| int| entity id|
| int| size|

#### 0x1F - Initialize Border Packet
| Type | Name |
| -------------| -------------|
| int| new absolute max size|
| double| new center x|
| double| new size|
| long| lerp time|
| int| warning blocks|
| double| old size|
| int| warning time|
| double| new center z|

#### 0x20 - Keep Alive Packet
| Type | Name |
| -------------| -------------|
| long| id|

#### 0x21 - Level Chunk With Light Packet
| Type | Name |
| -------------| -------------|
| int| z|
| int| x|
| ClientboundLightUpdatePacketData| light data|
| ClientboundLevelChunkPacketData| chunk data|

#### 0x22 - Level Event Packet
| Type | Name |
| -------------| -------------|
| boolean| global event|
| int| type|
| BlockPos| pos|
| int| data|

#### 0x23 - Level Particles Packet
| Type | Name |
| -------------| -------------|
| float| max speed|
| double| z|
| ParticleOptions| particle|
| double| y|
| double| x|
| int| count|
| boolean| override limiter|
| float| z dist|
| float| y dist|
| float| x dist|

#### 0x24 - Light Update Packet
| Type | Name |
| -------------| -------------|
| int| x|
| int| z|
| ClientboundLightUpdatePacketData| light data|

#### 0x25 - Login Packet
| Type | Name |
| -------------| -------------|
| Frozen| registry holder|
| GameType| previous game type|
| boolean| hardcore|
| long| seed|
| boolean| reduced debug info|
| GameType| game type|
| boolean| is flat|
| int| max players|
| ResourceKey\<DimensionType\>| dimension type|
| int| chunk radius|
| ResourceKey\<Level\>| dimension|
| int| player id|
| Set\<ResourceKey\<Level\>\>| levels|
| Optional\<GlobalPos\>| last death location|
| int| simulation distance|
| boolean| is debug|
| boolean| show death screen|

#### 0x26 - Map Item Data Packet
| Type | Name |
| -------------| -------------|
| MapPatch| color patch|
| boolean| locked|
| int| map id|
| List\<MapDecoration\>| decorations|
| byte| scale|

#### 0x27 - Merchant Offers Packet
| Type | Name |
| -------------| -------------|
| MerchantOffers| offers|
| int| villager level|
| int| villager xp|
| boolean| show progress|
| boolean| can restock|
| int| container id|

#### 0x28 - Pos
| Type | Name |
| -------------| -------------|
| short| xa|
| boolean| has rot|
| short| ya|
| byte| x rot|
| int| entity id|
| boolean| has pos|
| boolean| on ground|
| short| za|
| byte| y rot|

#### 0x29 - Pos Rot
| Type | Name |
| -------------| -------------|
| short| xa|
| boolean| has rot|
| short| ya|
| byte| x rot|
| int| entity id|
| boolean| has pos|
| boolean| on ground|
| short| za|
| byte| y rot|

#### 0x2A - Rot
| Type | Name |
| -------------| -------------|
| short| xa|
| boolean| has rot|
| short| ya|
| byte| x rot|
| int| entity id|
| boolean| has pos|
| boolean| on ground|
| short| za|
| byte| y rot|

#### 0x2B - Move Vehicle Packet
| Type | Name |
| -------------| -------------|
| double| x|
| float| x rot|
| double| y|
| double| z|
| float| y rot|

#### 0x2C - Open Book Packet
| Type | Name |
| -------------| -------------|
| InteractionHand| hand|

#### 0x2D - Open Screen Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| MenuType\<?\>| type|
| Component| title|

#### 0x2E - Open Sign Editor Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|

#### 0x2F - Ping Packet
| Type | Name |
| -------------| -------------|
| int| id|

#### 0x30 - Place Ghost Recipe Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| ResourceLocation| recipe|

#### 0x31 - Player Abilities Packet
| Type | Name |
| -------------| -------------|
| boolean| invulnerable|
| boolean| instabuild|
| float| flying speed|
| float| walking speed|
| boolean| is flying|
| boolean| can fly|

#### 0x32 - Player Chat Header Packet
| Type | Name |
| -------------| -------------|
| MessageSignature| header signature|
| byte[]| body digest|
| SignedMessageHeader| header|

#### 0x33 - Player Chat Packet
| Type | Name |
| -------------| -------------|
| BoundNetwork| chat type|
| PlayerChatMessage| message|

#### 0x34 - Player Combat End Packet
| Type | Name |
| -------------| -------------|
| int| killer id|
| int| duration|

#### 0x35 - Player Combat Enter Packet
| Type | Name |
| -------------| -------------|

#### 0x36 - Player Combat Kill Packet
| Type | Name |
| -------------| -------------|
| Component| message|
| int| killer id|
| int| player id|

#### 0x37 - Player Info Packet
| Type | Name |
| -------------| -------------|
| List\<PlayerUpdate\>| entries|
| Action| action|

#### 0x38 - Player Look At Packet
| Type | Name |
| -------------| -------------|
| Anchor| to anchor|
| Anchor| from anchor|
| boolean| at entity|
| double| z|
| double| y|
| double| x|
| int| entity|

#### 0x39 - Player Position Packet
| Type | Name |
| -------------| -------------|
| double| z|
| int| id|
| double| x|
| float| x rot|
| double| y|
| boolean| dismount vehicle|
| Set\<RelativeArgument\>| relative arguments|
| float| y rot|

#### 0x3A - Recipe Packet
| Type | Name |
| -------------| -------------|
| RecipeBookSettings| book settings|
| List\<ResourceLocation\>| recipes|
| List\<ResourceLocation\>| to highlight|
| State| state|

#### 0x3B - Remove Entities Packet
| Type | Name |
| -------------| -------------|
| IntList| entity ids|

#### 0x3C - Remove Mob Effect Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| MobEffect| effect|

#### 0x3D - Resource Pack Packet
| Type | Name |
| -------------| -------------|
| String| url|
| String| hash|
| boolean| required|
| Component| prompt|

#### 0x3E - Respawn Packet
| Type | Name |
| -------------| -------------|
| long| seed|
| GameType| previous player game type|
| boolean| is debug|
| boolean| is flat|
| ResourceKey\<DimensionType\>| dimension type|
| GameType| player game type|
| ResourceKey\<Level\>| dimension|
| boolean| keep all player data|
| Optional\<GlobalPos\>| last death location|

#### 0x3F - Rotate Head Packet
| Type | Name |
| -------------| -------------|
| byte| y head rot|
| int| entity id|

#### 0x40 - Section Blocks Update Packet
| Type | Name |
| -------------| -------------|
| boolean| suppress light updates|
| SectionPos| section pos|
| BlockState[]| states|
| short[]| positions|

#### 0x41 - Select Advancements Tab Packet
| Type | Name |
| -------------| -------------|
| ResourceLocation| tab|

#### 0x42 - Server Data Packet
| Type | Name |
| -------------| -------------|
| boolean| previews chat|
| Optional\<String\>| icon base64|
| Optional\<Component\>| motd|
| boolean| enforces secure chat|

#### 0x43 - Set Action Bar Text Packet
| Type | Name |
| -------------| -------------|
| Component| text|

#### 0x44 - Set Border Center Packet
| Type | Name |
| -------------| -------------|
| double| new center z|
| double| new center x|

#### 0x45 - Set Border Lerp Size Packet
| Type | Name |
| -------------| -------------|
| double| new size|
| long| lerp time|
| double| old size|

#### 0x46 - Set Border Size Packet
| Type | Name |
| -------------| -------------|
| double| size|

#### 0x47 - Set Border Warning Delay Packet
| Type | Name |
| -------------| -------------|
| int| warning delay|

#### 0x48 - Set Border Warning Distance Packet
| Type | Name |
| -------------| -------------|
| int| warning blocks|

#### 0x49 - Set Camera Packet
| Type | Name |
| -------------| -------------|
| int| camera id|

#### 0x4A - Set Carried Item Packet
| Type | Name |
| -------------| -------------|
| int| slot|

#### 0x4B - Set Chunk Cache Center Packet
| Type | Name |
| -------------| -------------|
| int| x|
| int| z|

#### 0x4C - Set Chunk Cache Radius Packet
| Type | Name |
| -------------| -------------|
| int| radius|

#### 0x4D - Set Default Spawn Position Packet
| Type | Name |
| -------------| -------------|
| float| angle|
| BlockPos| pos|

#### 0x4E - Set Display Chat Preview Packet
| Type | Name |
| -------------| -------------|
| boolean| enabled|

#### 0x4F - Set Display Objective Packet
| Type | Name |
| -------------| -------------|
| int| slot|
| String| objective name|

#### 0x50 - Set Entity Data Packet
| Type | Name |
| -------------| -------------|
| List\<DataItem\<?\>\>| packed items|
| int| id|

#### 0x51 - Set Entity Link Packet
| Type | Name |
| -------------| -------------|
| int| source id|
| int| dest id|

#### 0x52 - Set Entity Motion Packet
| Type | Name |
| -------------| -------------|
| int| id|
| int| ya|
| int| xa|
| int| za|

#### 0x53 - Set Equipment Packet
| Type | Name |
| -------------| -------------|
| int| entity|
| List\<Pair\<EquipmentSlot, ItemStack\>\>| slots|

#### 0x54 - Set Experience Packet
| Type | Name |
| -------------| -------------|
| int| total experience|
| float| experience progress|
| int| experience level|

#### 0x55 - Set Health Packet
| Type | Name |
| -------------| -------------|
| int| food|
| float| health|
| float| saturation|

#### 0x56 - Set Objective Packet
| Type | Name |
| -------------| -------------|
| String| objective name|
| RenderType| render type|
| Component| display name|
| int| method|

#### 0x57 - Set Passengers Packet
| Type | Name |
| -------------| -------------|
| int| vehicle|
| int[]| passengers|

#### 0x58 - Set Player Team Packet
| Type | Name |
| -------------| -------------|
| String| name|
| Optional\<Parameters\>| parameters|
| int| method|
| Collection\<String\>| players|

#### 0x59 - Set Score Packet
| Type | Name |
| -------------| -------------|
| String| objective name|
| Method| method|
| int| score|
| String| owner|

#### 0x5A - Set Simulation Distance Packet
| Type | Name |
| -------------| -------------|
| int| simulation distance|

#### 0x5B - Set Subtitle Text Packet
| Type | Name |
| -------------| -------------|
| Component| text|

#### 0x5C - Set Time Packet
| Type | Name |
| -------------| -------------|
| long| day time|
| long| game time|

#### 0x5D - Set Title Text Packet
| Type | Name |
| -------------| -------------|
| Component| text|

#### 0x5E - Set Titles Animation Packet
| Type | Name |
| -------------| -------------|
| int| fade out|
| int| fade in|
| int| stay|

#### 0x5F - Sound Entity Packet
| Type | Name |
| -------------| -------------|
| long| seed|
| SoundEvent| sound|
| float| volume|
| SoundSource| source|
| int| id|
| float| pitch|

#### 0x60 - Sound Packet
| Type | Name |
| -------------| -------------|
| int| y|
| int| x|
| SoundSource| source|
| float| pitch|
| int| z|
| long| seed|
| SoundEvent| sound|
| float| volume|

#### 0x61 - Stop Sound Packet
| Type | Name |
| -------------| -------------|
| ResourceLocation| name|
| SoundSource| source|

#### 0x62 - System Chat Packet
| Type | Name |
| -------------| -------------|
| Component| content|
| boolean| overlay|

#### 0x63 - Tab List Packet
| Type | Name |
| -------------| -------------|
| Component| footer|
| Component| header|

#### 0x64 - Tag Query Packet
| Type | Name |
| -------------| -------------|
| CompoundTag| tag|
| int| transaction id|

#### 0x65 - Take Item Entity Packet
| Type | Name |
| -------------| -------------|
| int| player id|
| int| amount|
| int| item id|

#### 0x66 - Teleport Entity Packet
| Type | Name |
| -------------| -------------|
| boolean| on ground|
| byte| y rot|
| double| x|
| byte| x rot|
| double| y|
| double| z|
| int| id|

#### 0x67 - Update Advancements Packet
| Type | Name |
| -------------| -------------|
| Set\<ResourceLocation\>| removed|
| Map\<ResourceLocation, Builder\>| added|
| boolean| reset|
| Map\<ResourceLocation, AdvancementProgress\>| progress|

#### 0x68 - Update Attributes Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| List\<AttributeSnapshot\>| attributes|

#### 0x69 - Update Mob Effect Packet
| Type | Name |
| -------------| -------------|
| byte| effect amplifier|
| int| effect duration ticks|
| int| entity id|
| byte| flags|
| MobEffect| effect|
| FactorData| factor data|

#### 0x6A - Update Recipes Packet
| Type | Name |
| -------------| -------------|
| List\<Recipe\<?\>\>| recipes|

#### 0x6B - Update Tags Packet
| Type | Name |
| -------------| -------------|
| Map\<ResourceKey\<? extends Registry\<?\>\>, NetworkPayload\>| tags|


## Play (Client -> Server)

#### 0x00 - Accept Teleportation Packet
| Type | Name |
| -------------| -------------|
| int| id|

#### 0x01 - Block Entity Tag Query
| Type | Name |
| -------------| -------------|
| int| transaction id|
| BlockPos| pos|

#### 0x02 - Change Difficulty Packet
| Type | Name |
| -------------| -------------|
| Difficulty| difficulty|

#### 0x03 - Chat Ack Packet
| Type | Name |
| -------------| -------------|
| Update| last seen messages|

#### 0x04 - Chat Command Packet
| Type | Name |
| -------------| -------------|
| Instant| time stamp|
| long| salt|
| Update| last seen messages|
| String| command|
| boolean| signed preview|
| ArgumentSignatures| argument signatures|

#### 0x05 - Chat Packet
| Type | Name |
| -------------| -------------|
| boolean| signed preview|
| String| message|
| Update| last seen messages|
| long| salt|
| Instant| time stamp|
| MessageSignature| signature|

#### 0x06 - Chat Preview Packet
| Type | Name |
| -------------| -------------|
| String| query|
| int| query id|

#### 0x07 - Client Command Packet
| Type | Name |
| -------------| -------------|
| Action| action|

#### 0x08 - Client Information Packet
| Type | Name |
| -------------| -------------|
| boolean| chat colors|
| int| model customisation|
| ChatVisiblity| chat visibility|
| HumanoidArm| main hand|
| int| view distance|
| String| language|
| boolean| text filtering enabled|
| boolean| allows listing|

#### 0x09 - Command Suggestion Packet
| Type | Name |
| -------------| -------------|
| int| id|
| String| command|

#### 0x0A - Container Button Click Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| int| button id|

#### 0x0B - Container Click Packet
| Type | Name |
| -------------| -------------|
| int| container id|
| ClickType| click type|
| ItemStack| carried item|
| Int2ObjectMap\<ItemStack\>| changed slots|
| int| button num|
| int| state id|
| int| slot num|

#### 0x0C - Container Close Packet
| Type | Name |
| -------------| -------------|
| int| container id|

#### 0x0D - Custom Payload Packet
| Type | Name |
| -------------| -------------|
| FriendlyByteBuf| data|
| ResourceLocation| identifier|

#### 0x0E - Edit Book Packet
| Type | Name |
| -------------| -------------|
| Optional\<String\>| title|
| int| slot|
| List\<String\>| pages|

#### 0x0F - Entity Tag Query
| Type | Name |
| -------------| -------------|
| int| transaction id|
| int| entity id|

#### 0x10 - Interact Packet
| Type | Name |
| -------------| -------------|
| int| entity id|
| Action| action|
| boolean| using secondary action|

#### 0x11 - Jigsaw Generate Packet
| Type | Name |
| -------------| -------------|
| int| levels|
| boolean| keep jigsaws|
| BlockPos| pos|

#### 0x12 - Keep Alive Packet
| Type | Name |
| -------------| -------------|
| long| id|

#### 0x13 - Lock Difficulty Packet
| Type | Name |
| -------------| -------------|
| boolean| locked|

#### 0x14 - Pos
| Type | Name |
| -------------| -------------|
| boolean| has pos|
| double| y|
| boolean| has rot|
| double| x|
| float| x rot|
| double| z|
| boolean| on ground|
| float| y rot|

#### 0x15 - Pos Rot
| Type | Name |
| -------------| -------------|
| boolean| has pos|
| double| y|
| boolean| has rot|
| double| x|
| float| x rot|
| double| z|
| boolean| on ground|
| float| y rot|

#### 0x16 - Rot
| Type | Name |
| -------------| -------------|
| boolean| has pos|
| double| y|
| boolean| has rot|
| double| x|
| float| x rot|
| double| z|
| boolean| on ground|
| float| y rot|

#### 0x17 - Status Only
| Type | Name |
| -------------| -------------|
| boolean| has pos|
| double| y|
| boolean| has rot|
| double| x|
| float| x rot|
| double| z|
| boolean| on ground|
| float| y rot|

#### 0x18 - Move Vehicle Packet
| Type | Name |
| -------------| -------------|
| float| y rot|
| double| y|
| double| x|
| float| x rot|
| double| z|

#### 0x19 - Paddle Boat Packet
| Type | Name |
| -------------| -------------|
| boolean| right|
| boolean| left|

#### 0x1A - Pick Item Packet
| Type | Name |
| -------------| -------------|
| int| slot|

#### 0x1B - Place Recipe Packet
| Type | Name |
| -------------| -------------|
| boolean| shift down|
| ResourceLocation| recipe|
| int| container id|

#### 0x1C - Player Abilities Packet
| Type | Name |
| -------------| -------------|
| boolean| is flying|

#### 0x1D - Player Action Packet
| Type | Name |
| -------------| -------------|
| Action| action|
| Direction| direction|
| int| sequence|
| BlockPos| pos|

#### 0x1E - Player Command Packet
| Type | Name |
| -------------| -------------|
| Action| action|
| int| id|
| int| data|

#### 0x1F - Player Input Packet
| Type | Name |
| -------------| -------------|
| boolean| is shift key down|
| boolean| is jumping|
| float| xxa|
| float| zza|

#### 0x20 - Pong Packet
| Type | Name |
| -------------| -------------|
| int| id|

#### 0x21 - Recipe Book Change Settings Packet
| Type | Name |
| -------------| -------------|
| RecipeBookType| book type|
| boolean| is open|
| boolean| is filtering|

#### 0x22 - Recipe Book Seen Recipe Packet
| Type | Name |
| -------------| -------------|
| ResourceLocation| recipe|

#### 0x23 - Rename Item Packet
| Type | Name |
| -------------| -------------|
| String| name|

#### 0x24 - Resource Pack Packet
| Type | Name |
| -------------| -------------|
| Action| action|

#### 0x25 - Seen Advancements Packet
| Type | Name |
| -------------| -------------|
| Action| action|
| ResourceLocation| tab|

#### 0x26 - Select Trade Packet
| Type | Name |
| -------------| -------------|
| int| item|

#### 0x27 - Set Beacon Packet
| Type | Name |
| -------------| -------------|
| Optional\<MobEffect\>| secondary|
| Optional\<MobEffect\>| primary|

#### 0x28 - Set Carried Item Packet
| Type | Name |
| -------------| -------------|
| int| slot|

#### 0x29 - Set Command Block Packet
| Type | Name |
| -------------| -------------|
| boolean| automatic|
| String| command|
| Mode| mode|
| BlockPos| pos|
| boolean| track output|
| boolean| conditional|

#### 0x2A - Set Command Minecart Packet
| Type | Name |
| -------------| -------------|
| boolean| track output|
| int| entity|
| String| command|

#### 0x2B - Set Creative Mode Slot Packet
| Type | Name |
| -------------| -------------|
| int| slot num|
| ItemStack| item stack|

#### 0x2C - Set Jigsaw Block Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| JointType| joint|
| ResourceLocation| target|
| String| final state|
| ResourceLocation| name|
| ResourceLocation| pool|

#### 0x2D - Set Structure Block Packet
| Type | Name |
| -------------| -------------|
| UpdateType| update type|
| String| name|
| boolean| show air|
| Vec3i| size|
| boolean| show bounding box|
| BlockPos| pos|
| StructureMode| mode|
| float| integrity|
| BlockPos| offset|
| String| data|
| long| seed|
| Rotation| rotation|
| Mirror| mirror|
| boolean| ignore entities|

#### 0x2E - Sign Update Packet
| Type | Name |
| -------------| -------------|
| BlockPos| pos|
| String[]| lines|

#### 0x2F - Swing Packet
| Type | Name |
| -------------| -------------|
| InteractionHand| hand|

#### 0x30 - Teleport To Entity Packet
| Type | Name |
| -------------| -------------|
| UUID| uuid|

#### 0x31 - Use Item On Packet
| Type | Name |
| -------------| -------------|
| InteractionHand| hand|
| BlockHitResult| block hit|
| int| sequence|

#### 0x32 - Use Item Packet
| Type | Name |
| -------------| -------------|
| int| sequence|
| InteractionHand| hand|



## Status (Server -> Client)

#### 0x00 - Status Response Packet
| Type | Name |
| -------------| -------------|
| ServerStatus| status|

#### 0x01 - Pong Response Packet
| Type | Name |
| -------------| -------------|
| long| time|


## Status (Client -> Server)

#### 0x00 - Status Request Packet
| Type | Name |
| -------------| -------------|

#### 0x01 - Ping Request Packet
| Type | Name |
| -------------| -------------|
| long| time|



## Login (Server -> Client)

#### 0x00 - Login Disconnect Packet
| Type | Name |
| -------------| -------------|
| Component| reason|

#### 0x01 - Hello Packet
| Type | Name |
| -------------| -------------|
| String| server id|
| byte[]| nonce|
| byte[]| public key|

#### 0x02 - Game Profile Packet
| Type | Name |
| -------------| -------------|
| GameProfile| game profile|

#### 0x03 - Login Compression Packet
| Type | Name |
| -------------| -------------|
| int| compression threshold|

#### 0x04 - Custom Query Packet
| Type | Name |
| -------------| -------------|
| int| transaction id|
| FriendlyByteBuf| data|
| ResourceLocation| identifier|


## Login (Client -> Server)

#### 0x00 - Hello Packet
| Type | Name |
| -------------| -------------|
| Optional\<UUID\>| profile id|
| Optional\<Data\>| public key|
| String| name|

#### 0x01 - Key Packet
| Type | Name |
| -------------| -------------|
| byte[]| keybytes|
| Either\<byte[], SaltSignaturePair\>| nonce or salt signature|

#### 0x02 - Custom Query Packet
| Type | Name |
| -------------| -------------|
| FriendlyByteBuf| data|
| int| transaction id|



